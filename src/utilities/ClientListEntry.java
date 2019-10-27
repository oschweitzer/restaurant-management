/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.swing.ImageIcon;
import model.ClientTable;

/**
 *
 * @author Jean-François
 */
public class ClientListEntry {
    
    private final ClientTable m_Client;
    private final ImageIcon m_Image = new ImageIcon(getClass().getResource("../images/img_client2.png"));
    
    public ClientListEntry(ClientTable a_Client)
    {
        m_Client = a_Client;
    }
    
    public String GetTitle()
    {
        return "Client #" + m_Client.getNumClientTable();
    }
    
    public ImageIcon GetImage()
    {
        return m_Image;
    }
    
    public ClientTable GetClient()
    {
        return m_Client;
    }
    
    @Override
    public String toString()
    {
        return GetTitle();
    }
}
