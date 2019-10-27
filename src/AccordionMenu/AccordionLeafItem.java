/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccordionMenu;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Jean-François
 */
public class AccordionLeafItem extends AccordionItem
{
    public AccordionLeafItem(String a_Text) 
    {
        super(a_Text);
        
        setFont(new Font("Times New Roman", Font.PLAIN, 20));
    }
    
    @Override
    public MouseAdapter getDefaultMouseActions() 
    {
        return new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setOpaque(true);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(false);
                repaint();
            }
        };
    }

    @Override
    public ImageIcon getDefaultNormalIcon() 
    {
        return new ImageIcon(getClass().getResource("../images/Unchecked.png"));
    }

    @Override
    public ImageIcon getDefaultSelectedIcon() 
    {
        return new ImageIcon(getClass().getResource("../images/Checked.png"));
    }
    
    @Override
    public Paint getDefaultBackgroundPaint() 
    {
        return null;
    }
}
