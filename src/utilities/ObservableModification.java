/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Jean-François
 */
public class ObservableModification 
{
    public enum Modification
    {
        Ajouter,
        Retirer
    }
    
    private Modification m_Modification;
    private Object m_Object;
    
    public ObservableModification(Modification a_Modif, Object a_List)
    {
        m_Modification = a_Modif;
        m_Object = a_List;
    }
    
    public Modification GetModification()
    {
        return m_Modification;
    }
    
    public Object GetObjects()
    {
        return m_Object;
    }
}
