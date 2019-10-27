/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import view.CommandeItemPanel;

/**
 *
 * @author Jean-François
 */
public class CommandeItemListEntry 
{
    private CommandeItemPanel m_Panel;
    
    public CommandeItemListEntry(CommandeItemPanel a_Panel)
    {
        m_Panel = a_Panel;
    }
    
    public CommandeItemPanel GetPanel()
    {
        return m_Panel;
    }
}
