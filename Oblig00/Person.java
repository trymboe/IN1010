class Person{
  Bil3 personligBil;

  public Person(Bil3 bil){
    this.personligBil = bil;
  }
  public void print(){
    System.out.println("bil nr: " + this.personligBil.hentNr());
  }
}
