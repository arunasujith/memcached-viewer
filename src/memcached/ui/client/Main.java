/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memcached.ui.client;

/**
 *
 * @author aruna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MemcahedUIFrame ui = new MemcahedUIFrame();
        ui.setTitle("Memcached Viewer");
        ui.setLocationRelativeTo(null);
        ui.setResizable(false);
        ui.setVisible(true);
    }
    
}
