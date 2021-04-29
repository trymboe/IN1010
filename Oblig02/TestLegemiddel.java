class TestLegemiddel{
  public static void main (String[] args){
    Vanedannende n1 = new Vanedannende("Vanedannende", 1, 2, 3);
    Narkotisk n2 = new Narkotisk("Narkotisk", 1, 2, 3);
    Legemidler n3 = new Vanlig("Vanlig", 1, 2);

    System.out.println(n1.hentId());
    System.out.println(n2.hentId());
  

    System.out.println(n2.toString());
    System.out.println(n3.toString());
    System.out.println(n1.toString());
  }
}
