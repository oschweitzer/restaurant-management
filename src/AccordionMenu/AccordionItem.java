/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccordionMenu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jean-François
 */
public abstract class AccordionItem extends JLabel implements Comparable
{
    protected int m_Index;
    protected boolean m_IsSelected = false;
    
    protected ImageIcon m_SelectedIcon;
    protected ImageIcon m_NormalIcon;
    
    protected String m_Text;
    
    public AccordionItem(String text) 
    {
        super(text);
        m_Text = text;
        
        setOpaque(false);
        addMouseListener(getDefaultMouseActions());
        setNormalIcon(getDefaultNormalIcon());
        setSelectedIcon(getDefaultSelectedIcon());
        setSelected(false);
        
        
        
    }
    
    public abstract ImageIcon getDefaultSelectedIcon();
    
    public abstract ImageIcon getDefaultNormalIcon();
    
    public abstract MouseAdapter getDefaultMouseActions();
    
    public abstract Paint getDefaultBackgroundPaint();
    
    public void Repaint()
    {
        setSelected(m_IsSelected);
        repaint();
    }
        
    public void setSelected(boolean a_IsSelected) 
    {
        m_IsSelected = a_IsSelected;
        if (a_IsSelected) 
        {
            setIcon(m_SelectedIcon);
            setFont(getFont().deriveFont(Font.BOLD));
        } 
        else 
        {
            setIcon(m_NormalIcon);
            setFont(getFont().deriveFont(Font.PLAIN));
        }
    }
    
    public void SwitchState()
    {
        m_IsSelected = !m_IsSelected;
        setSelected(m_IsSelected);
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        if (getDefaultBackgroundPaint() != null) 
        {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(getDefaultBackgroundPaint());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
        
        super.paintComponent(g);
    }
    
    @Override
    public int compareTo(Object o) 
    {
        AccordionItem target = (AccordionItem) o;
        if (GetIndex() == target.GetIndex()) 
        {
            return 0;
        } 
        else if (GetIndex() > target.GetIndex()) 
        {
            return 1;
        } 
        else 
        {
            return -1;
        }
    }
    
    public int GetIndex() 
    {
        return m_Index;
    }
    
    public void SetIndex(int index) 
    {
        m_Index = index;
    }
    
    public boolean IsSelected()
    {
        return m_IsSelected;
    }
    
    public void setSelectedIcon(ImageIcon selectedIcon) 
    {
        m_SelectedIcon = selectedIcon;
        setSelected(m_IsSelected);
    }
    
    public void setNormalIcon(ImageIcon normalIcon) 
    {
        m_NormalIcon = normalIcon;
        setSelected(m_IsSelected);
    }
    
    public ImageIcon getSelectedIcon() 
    {
        return m_SelectedIcon;
    }
    
    public ImageIcon getNormalIcon() 
    {
        return m_NormalIcon;
    }
    
    public String GetText()
    {
        return m_Text;
    }
}