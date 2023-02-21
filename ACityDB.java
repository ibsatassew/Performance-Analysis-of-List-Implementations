/** 
 * Documentation 
 
 * 
*/

class ACityDB<E> extends City{
    private int maxSize;
    private int size;
    private City[] cityArray;


public ACityDB(int size){
    super();
    this.maxSize = size;
    this.size = 0;
    cityArray = new City[size];
    }
//insert records
public void insert(City c){
    assert size < maxSize : "Database is full.";
    cityArray[size] = c;
    size++;
}
//Delete records by name (city and state)
// n: name; s: state;
public void delete(String n, String s){
    for(int i = 0; i<size; i++){
        if(cityArray[i].getName().equals(n) && cityArray[i].getState().equals(s) ){
           for(int j = i; j<size-1; j++ ){
            cityArray[j] = cityArray[j+1];  
           }
           size--;
        }
    }
} 
//Delete records by  coordinate
// lat: latitude; lon: longitude
public void delete(double lat, double lon) {
    for(int i = 0; i<size; i++){
        if(cityArray[i].getLat() == lat && cityArray[i].getLon() == lon ){
           for(int j = i; j<size-1; j++ ){
            cityArray[j] = cityArray[j+1];  
           }
           size--;
        }
    }
} 
//Search by name (city and state)
public City search(String n, String s){
    for(int i = 0; i<size; i++){
        if(cityArray[i].getName().equals(n) && cityArray[i].getState().equals(s) ){
            return cityArray[i];  
        }  
    }
    return null; 
  // should return null if not found but in the sample output given it prints "No such city"
} 
//Search by coordinate
public City search(double lat, double lon){
    for(int i = 0; i<size; i++){
        if(cityArray[i].getLat()==lat && cityArray[i].getLon()== lon){
            return cityArray[i];  
        }  
    }
    return null; 
}
//Print all names of cities with a given name of state s.
public void printAllState(String s){
    for(int i = 0; i<size; i++){
        if(cityArray[i].getState().equals(s)){
            System.out.println(cityArray[i].getName());  
        }  
    }
}
//Print all names of cities and their states within a given distance (d) from a specified point (lat, lon).
//The for-loop iterates starting from the bottom so the result is consistent with I/O specifications. 
public void printAllDistance(double lat, double lon, double d){
    for(int i = 0; i<size; i++){
        double dx = lat - cityArray[i].getLat();
        double dy = lon - cityArray[i].getLon();
        double distance = Math.sqrt(dx*dx + dy*dy);
        if(distance <= d){
            System.out.println(cityArray[i].getName()+","+cityArray[i].getState());
        }
    }
    
}

//Print all names of cities and their states with a given range of population (from, to).
public void printAllPopulation(int from, int to){
    for(int i = 0; i<size; i++){
        if(from<=cityArray[i].getPop() && cityArray[i].getPop() <= to){
            System.out.println(cityArray[i].getName()+","+cityArray[i].getState());
        }
    }
}


}

