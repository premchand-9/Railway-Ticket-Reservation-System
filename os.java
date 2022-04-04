class os{
public os() {
    String os = System.getProperty("os.name");
    System.out.println("Using System Property: " + os);
}
public static void main(String[] args){
new os();
}
}