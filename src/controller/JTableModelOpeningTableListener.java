/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.event.TableModelEvent;
import view.MainFrame;
import view.TableOpening;

/**
 *
 * @author Olivier
 */
public class JTableModelOpeningTableListener implements javax.swing.event.TableModelListener
{
    private TableOpening ouvertureTable;
    
    public JTableModelOpeningTableListener(TableOpening ouvertureTable)
    {
        this.ouvertureTable = ouvertureTable;
    }

    @Override
    public void tableChanged(TableModelEvent e)
    {
    }

}
