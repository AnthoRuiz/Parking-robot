/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import VO.Parking;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jarvis
 */
public class CheckEquals {
    
    public int checkParkings(Parking parking, ArrayList<Parking> parkingCloudList){
        Iterator<Parking> parkingIterator =  parkingCloudList.iterator();
        Parking parkingCloud = new Parking();
        int i = 1;
        boolean band = false;
        while(parkingIterator.hasNext() && !band){
           parkingCloud =  parkingIterator.next();
           if(parkingCloud.equals(parking)){
               band = true;
           }else{
               i++;
           }
        }
        return i;       
    }
    
}

/*
Iterator<String> nombreIterator = nombreArrayList.iterator();
while(nombreIterator.hasNext()){
	String elemento = nombreIterator.next();
	System.out.print(elemento+" / ");
}
*/