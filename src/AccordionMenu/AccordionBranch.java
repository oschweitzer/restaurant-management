/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccordionMenu;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jean-François
 */
public class AccordionBranch extends JPanel
{
    private int m_Count = 0;
    private JPanel m_Container;
    private List<JLabel> m_FooItems;
        
    public AccordionBranch() 
    {
        initComponents();
        m_Container.setOpaque(false);
        m_Container.setLayout(new GridLayout(0, 1, 0,5));
        m_FooItems = new ArrayList<JLabel>();
    }
        
    public void AdjustItems(int a_Max) 
    {
        for (JLabel l : m_FooItems) 
        {
            m_Container.remove(l);
        }
        
        m_FooItems.clear();
        
        for (int i = a_Max; i > GetCount(); i--) 
        {
            JLabel lab = new JLabel("");
            lab.setBackground(Color.green);
            m_Container.add(lab);
            m_FooItems.add(lab);
        }
    }
    
    public void addItem(AccordionItem a_Item) 
    {
        m_Container.add(a_Item);
        m_Count++;
    }
    
    public int GetCount() 
    {
        return m_Count;
    }
    
    private void initComponents() 
    {
        m_Container = new javax.swing.JPanel();

        m_Container.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        
        this.setLayout(layout);
        
        layout.setHorizontalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(m_Container, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(m_Container, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
}
