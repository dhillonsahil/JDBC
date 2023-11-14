public class LearnDate {
    public static void main(String[] args) {
        java.util.Date dl = new java.util.Date();
        System.out.println("util date :- "+dl);

        Long l = new java.util.Date().getTime();
        java.sql.Date sd= new java.sql.Date(l);
        System.out.println("sql date :- "+sd);
    }
}
