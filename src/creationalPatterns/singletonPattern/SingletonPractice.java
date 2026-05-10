package creationalPatterns.singletonPattern;





public class SingletonPractice {
    static void main() {
        RelationalDatabaseConnection relationalDatabaseConnection = RelationalDatabaseConnection.getInstance();
        RelationalDatabaseConnection relationalDatabaseConnection1 = RelationalDatabaseConnection.getInstance();
        RelationalDatabaseConnection relationalDatabaseConnection2 = RelationalDatabaseConnection.getInstance();

        NonRelationalDatabaseConnection nonRelationalDatabaseConnection = NonRelationalDatabaseConnection.getInstance();
        NonRelationalDatabaseConnection nonRelationalDatabaseConnection1 = NonRelationalDatabaseConnection.getInstance();
        NonRelationalDatabaseConnection nonRelationalDatabaseConnection2 = NonRelationalDatabaseConnection.getInstance();


        if(relationalDatabaseConnection.equals(relationalDatabaseConnection1) && relationalDatabaseConnection1.equals(relationalDatabaseConnection2)){
            System.out.println("Same object but different references");
        }
        if(relationalDatabaseConnection == relationalDatabaseConnection1 && relationalDatabaseConnection1 == relationalDatabaseConnection2){
            System.out.println("Same object but different references");
        }

        if(nonRelationalDatabaseConnection.equals(nonRelationalDatabaseConnection1) && nonRelationalDatabaseConnection1.equals(nonRelationalDatabaseConnection2)){
            System.out.println("Same object but different references");
        }
        if(nonRelationalDatabaseConnection == nonRelationalDatabaseConnection1 && nonRelationalDatabaseConnection1 == nonRelationalDatabaseConnection2){
            System.out.println("Same object but different references");
        }

    }
}


/**
 * One way of writing lazy initialization Singleton. Make an object when needed.
 */
class RelationalDatabaseConnection {
    private static RelationalDatabaseConnection relationalDatabaseConnection;

    private RelationalDatabaseConnection(){}

    public static RelationalDatabaseConnection getInstance(){
        if(relationalDatabaseConnection == null){
            relationalDatabaseConnection = new RelationalDatabaseConnection();
        }
        return relationalDatabaseConnection;
    }
}

/**
 *
 * Eager Initialization of Singleton
 *
 */
class NonRelationalDatabaseConnection {
    private static final NonRelationalDatabaseConnection INSTANCE = new NonRelationalDatabaseConnection();

    private NonRelationalDatabaseConnection(){}

    public static NonRelationalDatabaseConnection getInstance(){
        return INSTANCE;
    }
}


/**
 * Thread safe lazy initialization Singleton. Make an object when needed.
 */
class ThreadSafeRelationalDatabaseConnection {
    private static ThreadSafeRelationalDatabaseConnection threadSafeRelationalDatabaseConnection;

    private ThreadSafeRelationalDatabaseConnection(){}

    public static ThreadSafeRelationalDatabaseConnection getInstance(){
        synchronized (ThreadSafeRelationalDatabaseConnection.class){
            if(threadSafeRelationalDatabaseConnection == null){
                threadSafeRelationalDatabaseConnection = new ThreadSafeRelationalDatabaseConnection();
            }
        }
        return threadSafeRelationalDatabaseConnection;
    }
}





