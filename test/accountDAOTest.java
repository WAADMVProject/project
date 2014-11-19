/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dmv.tobedeleteddao.accountDAO;
import dmv.tobedeleteddomain.accountEntity;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author SAMIPC
 */
public class accountDAOTest {
    
    public accountDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void accountTest() throws SQLException{
//        accountEntity account = new accountEntity();
//        account.setFirstName("sa");
//        int id = 0;
//        try{
//        accountDAO accountdao = new accountDAO();
//        id = accountdao.addAccount(account);
//        }catch(IOException ex){
//            
//        }
//        assertEquals(3,id);
//        
//    }
}
