/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.utilities;

import com.rumahsakit.bayar.model.Lookup;
import com.rumahsakit.bayar.dao.LookupDAO;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author General Bassamtiano
 */
public class MyMouseMotionListener extends MouseMotionAdapter {
    
    private Lookup[] KODE_POLI = null;
    private Map KODE_POLIMAP = new HashMap();
        @Override
        public void mouseMoved(MouseEvent evt) {
            // Process current position of cursor while all mouse buttons are up.
            process(evt.getPoint());
        }
        @Override
        public void mouseDragged(MouseEvent evt) {
            // Process current position of cursor while mouse button is pressed.
            process(evt.getPoint());
        }
        
        private void process(Point point) {
            LookupDAO _lookupDao = new LookupDAO();
        KODE_POLI = (Lookup[]) _lookupDao.find("KODE_POLI").toArray(new Lookup[0]);

        for (int i = 0; i < KODE_POLI.length; i++) {
            Lookup _eval = KODE_POLI[i];
            KODE_POLIMAP.put(_eval.getKode_character().trim(), _eval);
        }
        }
    
}
