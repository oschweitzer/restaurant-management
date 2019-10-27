/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccordionMenu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Jean-François
 */
public class AccordionRootItem extends AccordionItem
{
    private AccordionBranch m_BranchPanel;

    public AccordionRootItem(String text) 
    {
        super(text);
        m_BranchPanel = new AccordionBranch();
        
        setFont(new Font("Times New Roman", Font.BOLD, 22));
    }
    
    @Override
    public ImageIcon getDefaultNormalIcon() 
    {
        return new ImageIcon(getClass().getResource("../images/ArrowCollapsed.png"));
    }

    @Override
    public ImageIcon getDefaultSelectedIcon() 
    {
        return new ImageIcon(getClass().getResource("../images/ArrowExpanded.png"));
    }
    
    @Override
    public MouseAdapter getDefaultMouseActions() 
    {
        return new MouseAdapter() 
        {

            @Override
            public void mouseEntered(MouseEvent e) 
            {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
    }

    @Override
    public Paint getDefaultBackgroundPaint() 
    {
        Color c1, c2;
        if (IsSelected())
        {
            c2 = Color.decode("#f0f0f4");
            c1 = c2.darker();
        } 
        else 
        {
            c1 = c2 = Color.decode("#e2e2e9");
            c2 = c1.darker();
        }
        
        return new GradientPaint(0, 0, c1, 0, getHeight(), c2);
    }
    
    public AccordionBranch GetBranchPanel() 
    {
        return m_BranchPanel;
    }
}