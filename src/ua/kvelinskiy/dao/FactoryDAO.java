package ua.kvelinskiy.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FactoryDAO {
   // private static final Logger logger = Logger.getLogger(FactoryDAO.class);
    private static FactoryDAO instance = null;
    private DataSource ds;

    private FactoryDAO() throws NamingException {
        InitialContext initContext = new InitialContext();
        ds = (DataSource) initContext.lookup("java:comp/env/jdbc/library");
    }

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            try {
                instance = new FactoryDAO();
            } catch (NamingException ex) {
                //logger.error("Bad instance " + ex);
            }
        }
        return instance;
    }

    public UsersDAO getUsersDAO() {
        return new UsersDAO(ds);
    }

    public GenresDAO getGenresDAO(){
        return new GenresDAO(ds);
    }

    public CatalogueDAO getCatalogueDAO(){
        return new CatalogueDAO(ds);
    }

    public BooksDAO getBooksDAO(){
        return  new BooksDAO(ds);
    }
}
