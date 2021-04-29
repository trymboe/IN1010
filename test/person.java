class Person{
  private String navn;
  private int alder;

  public Person(String navn, int alder){
    this.navn = navn;
    this.alder = alder;

  }
  public void fyllAar(){
    this.alder++;
  }

  public static void print(){
    System.out.println("Hallo");
  }
}
