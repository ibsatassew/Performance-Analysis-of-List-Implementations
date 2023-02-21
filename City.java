/**
*
* City database record definition
*
*/
class City {
   private String name;
   private String state;
   private double latitude;
   private double longitude;
   private int population;

   public City() {
   this.name = null;
   this.state = null;
   this.latitude = 0.0;
   this.longitude = 0.0;
   this.population = 0;
   }       
   
   public City(String n, String s, double lat, double lon, int pop) {
      this.name = n;
      this.state = s;
      this.latitude = lat;
      this.longitude = lon;
      this.population = pop;
   }
   public String getName(){
      return name;
   }
   public String getState(){
      return state;
   }
   public double getLat(){
      return latitude;
   }
   public double getLon(){
      return longitude;
   }
   public int getPop(){
      return population;
   }
   public void setName(String newName){
      this.name = newName;
   }
   public void setState(String newState){
      this.state = newState;
   }
   public void setLat(double newLat){
      this.latitude = newLat;
   }
   public void setLon(double newLon){
      this.longitude = newLon;
   }
   public void setPop(int newPop){
      this.population = newPop;
   }
   public String toString() {
      StringBuffer out = new StringBuffer();
      out.append(name).append(" ");
      out.append(state).append(" ");
      out.append(latitude).append(" ");
      out.append(longitude).append(" ");
      out.append(population);
      return out.toString();
  }

}
