public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User elias = new User("elias");
        User anna = new User("anna");
        User pekka = new User("pekka");

        library.addUnprotectedDocument("doc-public-1", "This is a public document.");
        library.addProtectedDocument("doc-private-1", "Top secret project notes.", "elias", "anna");
        library.addProtectedDocument("doc-private-2", "Only Pekka can read this.", "pekka");

        DocumentInterface publicDoc = library.getDocument("doc-public-1");
        DocumentInterface privateDoc1 = library.getDocument("doc-private-1");
        DocumentInterface privateDoc2 = library.getDocument("doc-private-2");

        System.out.println("=== Public document ===");
        System.out.println("Creation date: " + publicDoc.getCreationDate());
        System.out.println("Elias reads: " + publicDoc.getContent(elias));
        System.out.println("Anna reads: " + publicDoc.getContent(anna));

        System.out.println("\n=== Protected document 1 ===");
        System.out.println("Creation date: " + privateDoc1.getCreationDate());

        try {
            System.out.println("Elias reads: " + privateDoc1.getContent(elias));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Pekka reads: " + privateDoc1.getContent(pekka));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Protected document 2 ===");

        try {
            System.out.println("Pekka reads: " + privateDoc2.getContent(pekka));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Anna reads: " + privateDoc2.getContent(anna));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}