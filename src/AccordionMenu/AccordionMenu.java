/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccordionMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Inspiree de : http://www.codeproject.com/Articles/125398/Java-Accordion-Menu-Visual-Effects-and-Customizati
 * @author Jean-François
 */
public class AccordionMenu extends JPanel
{
    public static int MINIMUM_SIZE = 25;
    
    private int menuCount;
    private int timeStep = 10;
    private int freeAvaiableRows;
    private int branchAvaiableSpace;
    private int menusSize = MINIMUM_SIZE;
    
    private AccordionRootItem selectedMenu;
    private AccordionLeafItem selectedLeaf;
    private AccordionRootItem lastSelectedMenu;

    private Color selectionColor = null;
    
    private int showingSize;
    private int hidingSize;
    
    private TreeMap<AccordionRootItem, List<AccordionLeafItem>> leafMap;
    
    public AccordionMenu(String menuDescriptor) 
    {
        this.addComponentListener(getDefaultComponentAdapter());
        this.setLayout(null);
        this.leafMap = new TreeMap<AccordionRootItem, List<AccordionLeafItem>>();
        createMenusFromDescriptor(menuDescriptor);
    }
    
    public void createMenusFromDescriptor(String a_MenuDescriptor) 
    {
        leafMap = new TreeMap<AccordionRootItem, List<AccordionLeafItem>>();
        
        menuCount = 0;
        boolean first = true;
        String[] menus = a_MenuDescriptor.split("!");
        
        
        for (String menu : menus) 
        {
            String name = menu.split(":")[0];
            AccordionRootItem menuItem = createRootItem(name.split(",")[0], name.split(",")[1]);
            menuItem.addMouseListener(getDefaultMenuMouseAdapter());

            if (first) 
            {
                first = false;
                menuItem.setSelected(true);
            }
            
            String leafs = menu.split(":")[1];
            List<AccordionLeafItem> leafList = new ArrayList<AccordionLeafItem>();
            
            for (String leaf : leafs.split(";")) 
            {
                AccordionLeafItem leafItem = createLeafItem(leaf.split(",")[0], leaf.split(",")[1]);
                menuItem.GetBranchPanel().addItem(leafItem);
                leafItem.addMouseListener(getDefaultLeafMouseAdapter());
                leafList.add(leafItem);
            }
            
            menuCount++;
            menuItem.SetIndex(menuCount);
            leafMap.put(menuItem, leafList);
            this.add(menuItem.GetBranchPanel());
        }
        menuCount = leafMap.keySet().size();
        calculateAvaiableSpace();
    }
    
    public MouseAdapter getDefaultLeafMouseAdapter() 
    {
        return new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                AccordionLeafItem item = (AccordionLeafItem) e.getSource();
                if(item != null)
                {
                    for (AccordionLeafItem leaf : getAllLeafs()) 
                    {
                        leaf.Repaint();
                    }
               
                    item.SwitchState();
                } 
            }
        };
    }
    
    public void ResetLeafsSelection()
    {
        for (AccordionLeafItem leaf : getAllLeafs()) 
        {
            leaf.setSelected(false);
            leaf.repaint();
        }     
    }
    
    public List<AccordionLeafItem> GetLeafSelection()
    {
        List<AccordionLeafItem> selection = new ArrayList<AccordionLeafItem>();
        for (AccordionLeafItem leaf : getAllLeafs()) 
        {
            if(leaf.IsSelected())
            {
                selection.add(leaf);
            }    
        } 
        
        return selection;
    }
    
    private MouseAdapter getDefaultMenuMouseAdapter() 
    {
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                AccordionRootItem item = (AccordionRootItem) e.getSource();
                for (AccordionRootItem menu : getMenus()) 
                {
                    if (menu.IsSelected()) 
                    {
                        lastSelectedMenu = menu;
                        menu.setSelected(false);
                    }
                }
                item.setSelected(true);
                if (lastSelectedMenu == item) 
                {
                    return;
                }
            }
        };
    }
    
    
    public void update() 
    {
        for (AccordionRootItem menu : getMenus()) 
        {
            menu.GetBranchPanel().updateUI();
        }
    }
    
    public void updateLeafs() 
    {
        for (AccordionLeafItem leaf : getAllLeafs()) 
        {
            leaf.repaint();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        calculateAvaiableSpace();
        
        int currentY = 0;
        for (AccordionRootItem menu : getMenus()) 
        {
            menu.setSize(getWidth(), menusSize);
            menu.setLocation(0, currentY);

            if (menu == lastSelectedMenu && !menu.IsSelected()) 
            {
                currentY += menusSize;
                menu.GetBranchPanel().setSize(getWidth(), hidingSize);
                menu.GetBranchPanel().setLocation(0, currentY);
                currentY += hidingSize;
            }
            
            if (menu.IsSelected()) 
            {
                currentY += menusSize;
                menu.GetBranchPanel().AdjustItems(freeAvaiableRows);
                menu.GetBranchPanel().setSize(getWidth(), showingSize);
                menu.GetBranchPanel().setLocation(0, currentY);
                currentY += showingSize;
            } 
            else if (!menu.IsSelected() && menu != lastSelectedMenu) 
            {
                menu.GetBranchPanel().setSize(0, 0);
                currentY += this.menusSize;
            }
        }
        
        update();
    }
    
    public List<AccordionRootItem> getMenus() 
    {
        return new ArrayList<AccordionRootItem>(leafMap.keySet());
    }
    
    public AccordionRootItem getMenu(String name) 
    {
        for (AccordionRootItem menu : leafMap.keySet()) 
        {
            if (menu.getName().equals(name)) 
            {
                return menu;
            }
        }
        
        return null;
    }
    
    public List<AccordionLeafItem> getAllLeafs() 
    {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        
        for (AccordionRootItem menu : leafMap.keySet()) 
        {
            leafs.addAll(leafMap.get(menu));
        }
        return leafs;
    }
    
    public List<AccordionLeafItem> getLeafsOf(String menuName) 
    {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        for (AccordionRootItem menu : leafMap.keySet())
        {
            if (menu.getName().equals(menuName)) 
            {
                leafs.addAll(leafMap.get(menu));
            }
        }
        return leafs;
    }
    
    public AccordionLeafItem getLeaf(String name) 
    {
        for (AccordionLeafItem leaf : getAllLeafs()) 
        {
            if (leaf.getName().equals(name)) 
            {
                return leaf;
            }
        }
        return null;
    }
    
    public ComponentAdapter getDefaultComponentAdapter() 
    {
        return new ComponentAdapter() 
        {
            @Override
            public void componentResized(ComponentEvent e) 
            {
                calculateAvaiableSpace();
            }
        };
    }
    
    public void calculateAvaiableSpace()
    {
        int height = getHeight();
        double scale = menusSize / 20;
        branchAvaiableSpace = height - (menuCount * menusSize);
        freeAvaiableRows = (int) (Math.ceil(height / (menusSize)) * scale) - menuCount;
        showingSize = branchAvaiableSpace;
        hidingSize = 0;
        update();
    }
    
    private AccordionRootItem createRootItem(String title, String name) 
    {
        AccordionRootItem menu = new AccordionRootItem(title);
        menu.setName(name);
        add(menu);
        return menu;
    }
    
    private AccordionLeafItem createLeafItem(String title, String name) 
    {
        AccordionLeafItem leaf = new AccordionLeafItem(title);
        leaf.setName(name);
        //add(leaf);
        return leaf;
    }
    
    public void addNewLeafTo(String menuName, String leafName, String leafTitle) 
    {
        for (AccordionRootItem menu : getMenus()) 
        {
            if (menu.getName().equals(menuName)) 
            {
                AccordionLeafItem item = createLeafItem(leafTitle, leafName);
                item.addMouseListener(getDefaultLeafMouseAdapter());
                this.leafMap.get(menu).add(item);
                menu.GetBranchPanel().addItem(item);
                return;
            }
        }
    }
    
    public void addNewMenu(String menuName, String menuTitle) 
    {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        AccordionRootItem menu = createRootItem(menuTitle, menuName);
        menu.addMouseListener(getDefaultMenuMouseAdapter());
        menu.SetIndex(menuCount);
        
        if (menuCount == 0) 
        {
            menu.setSelected(true);
//            lastSelectedMenu = menu;
        }
        
        menuCount++;
        this.leafMap.put(menu, leafs);
        this.add(menu.GetBranchPanel());
    }
    
    @Override
    public void setBackground(Color back) 
    {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : leafMap.keySet()) 
        {
            menu.setBackground(back);
            menu.GetBranchPanel().setBackground(back);
            
            if (selectionColor == null) 
            {
                for (AccordionLeafItem leaf : leafMap.get(menu)) 
                {
                    leaf.setBackground(back);
                }
            }
        }
    }
    
    public void setMenuBorders(Border border) 
    {
        for (AccordionRootItem menu : getMenus()) 
        {
            menu.setBorder(border);
        }
    }
    
    public void setMenuHorizontalAlignment(int alignment) 
    {
        if (this.leafMap == null)
        {
            return;
        }
        
        for (AccordionRootItem menu : leafMap.keySet()) 
        {
            menu.setHorizontalAlignment(alignment);
        }
    }
    
    public void setLeafHorizontalAlignment(int alignment)
    {
        if (this.leafMap == null) 
        {
            return;
        }
        
        for (AccordionLeafItem leaf : getAllLeafs()) 
        {
            leaf.setHorizontalAlignment(alignment);
        }
    }
    
    public Color getSelectionColor() 
    {
        return selectionColor;
    }
    
    public void setSelectionColor(Color selectionColor) 
    {
        this.selectionColor = selectionColor;
        for (AccordionRootItem menu : leafMap.keySet())
        {
            for (AccordionLeafItem leaf : leafMap.get(menu)) 
            {
                leaf.setBackground(selectionColor);
            }
        }
    }
    
    public void setFont(Font font) 
    {
        if (this.leafMap == null) 
        {
            return;
        }
        for (AccordionRootItem menu : getMenus()) 
        {
            menu.setFont(font);
            for (AccordionLeafItem leaf : getLeafsOf(menu.getName())) 
            {
                leaf.setFont(font);
            }
        }
    }
    
    @Override
    public void setForeground(Color fg)
    {
        if (this.leafMap == null) 
        {
            return;
        }
        
        for (AccordionRootItem menu : getMenus()) 
        {
            menu.setForeground(fg);
            for (AccordionLeafItem leaf : getLeafsOf(menu.getName())) 
            {
                leaf.setForeground(fg);
            }
        }
    }
    
    public int getMenuCount() 
    {
        return menuCount;
    }

    public int getMenusSize() 
    {
        return menusSize;
    }

    public void setMenusSize(int menusSize)
    {
        if (menusSize < MINIMUM_SIZE)
        {
            setMenusSize(MINIMUM_SIZE);
        }
        
        this.menusSize = menusSize;
        calculateAvaiableSpace();
        repaint();
    }

    public int getTimeStep() 
    {
        return timeStep;
    }

    public void setTimeStep(int timeStep)
    {
        this.timeStep = timeStep;
    }

    public AccordionLeafItem getSelectedLeaf() 
    {
        return selectedLeaf;
    }

    public AccordionRootItem getSelectedMenu() 
    {
        return selectedMenu;
    }
}