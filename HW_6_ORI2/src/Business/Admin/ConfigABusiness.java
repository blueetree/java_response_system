/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Admin;

import Business.Market.Customer;
import Business.Market.Market;
import Business.Market.MarketList;
import Business.Market.MarketOffer;
import Business.Market.MarketOfferCatalog;
import Business.SalesPerson.SalesPerson;
import Business.SalesPerson.SalesPersonDirectory;
import Business.Supplier.Product;
import Business.Supplier.ProductCatalog;
import Business.Supplier.Supplier;
import Business.Supplier.SupplierDirectory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.UnsupportedEncodingException;    
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author liuch
 */
public class ConfigABusiness {
    
    public static void getConfig(UserAccountDirectory ud, PersonDirectory pd,MarketList marketList,SupplierDirectory supplierDirectory,MarketOfferCatalog marketOfferCatalog,SalesPersonDirectory spd)
    {
       for(int k =0;k<100;k++)
       {
           Person p = pd.addPerson();
           p.setFirstName(getName());
           p.setLastName(getName());
           UserAccount ua =ud.addUserAccount();
           String userName = getName();
           ua.setUserName(userName);
           System.out.print("user name: "+userName+"        ");
           String password =getPassWord();
            String encoded =DatatypeConverter.printBase64Binary(password.getBytes());
       //    int savedWord=password.hashCode();
          ua.setPassWord(encoded);
            System.out.print("   password: "+password);
           ua.setPerson(p);
           System.out.print(" Person name "+ p.getFirstName()+"   " );
          if(k%3==0)
          { ua.setRole(Role.Procurement_Supplier);
            //System.out.println("Role is HR"+ud.getUserAccountDirectory().size()+"length of Person"+pd.getPersonDirectory().size());
            System.out.println("Role is Supplier");
            System.out.println("          ");
            
          }
          else if(k%3==1){
              ua.setRole(Role.Sales_Person);
            //System.out.println("Role is HR"+ud.getUserAccountDirectory().size()+"length of Person"+pd.getPersonDirectory().size());
            System.out.println("Role is Salesman");
            System.out.println("          ");
          }
          else
          {ua.setRole(Role.System_admin);
           System.out.println("Role is Admin");
            System.out.println("          ");
          }
         
       }
       ConfigMarket(marketList);
       ConfigProduct(supplierDirectory);
       ConfigMarketOffer(marketOfferCatalog,marketList,supplierDirectory);
       configSalesPersons(spd);
    //   printSupplierA(supplierDirectory.getSupplierDirectory().get(0));
   }
    public static void ConfigMarketOffer(MarketOfferCatalog marketOfferCatalog,MarketList marketList,SupplierDirectory supplierDirectory)
    {
        int i=0;
        for(Market market:marketList.getMarketList())
        {
            i=i++;
            for(Supplier supplier:supplierDirectory.getSupplierDirectory())
            {
                
               
              String csvFile = "MarketOffer2.csv";
              BufferedReader br = null;
             String line = "";
            String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            while ((line = br.readLine()) != null) {
               
                 MarketOffer marketoffer=marketOfferCatalog.addMarketOffer();
                 marketoffer.setMarket(market);
                String[] CustomerList = line.split(cvsSplitBy);
                String productName =CustomerList[0];
                Product product=supplier.getProductCatalog().searchProductWithName(productName);
                marketoffer.setProduct(product);
                
                int max = 20;
                int min = 1;
                Random random = new Random();
                
                int ran= random.nextInt(max)%(max-min+1) + min;
                System.out.println("getting random number"+ran);
                
            // double ran=Math.random();
                String floorPrice =CustomerList[1];
                double floorP=i+ran*(Float.valueOf(floorPrice));
                System.out.println("Price"+floorP+"MARKET ID"+market.getMarketID()+product.getProductName()+"Supplier Name"+supplier.getSupplierName());
                
                marketoffer.setFloorPrice(floorP);
                String targetPrice=CustomerList[2];
                double targetP=i+ran*(Float.valueOf(targetPrice));
                marketoffer.setTargetPrice(targetP);
                String ceilingPrice = CustomerList[3];
                double ceilingP=i+ran*(Float.valueOf(ceilingPrice));
                marketoffer.setCellingPrice(ceilingP);
                String productQuantity = CustomerList[4];
                int quantity = Integer.parseInt(productQuantity);
                marketoffer.setAvailible(quantity);
            } 
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
                
                
            }
          
            
        }
        
    
    }
    public static void ConfigProduct(SupplierDirectory supplierDirectory)
    {
      Supplier supplierA=supplierDirectory.addSupplier();
       supplierA.setSupplierName("Supplier A");
       
       Supplier supplierB=supplierDirectory.addSupplier();
       supplierB.setSupplierName("Supplier B");
       
       Supplier supplierC=supplierDirectory.addSupplier();
       supplierC.setSupplierName("Supplier C");
       
       Supplier supplierD=supplierDirectory.addSupplier();
       supplierD.setSupplierName("Supplier D");
       
       Supplier supplierE=supplierDirectory.addSupplier();
       supplierE.setSupplierName("Supplier E");
       for(Supplier supplier: supplierDirectory.getSupplierDirectory())
       {
           configProducts(supplier);
                  
       }
        
    }
   public static void printSupplierA(Supplier supplier)
   {
       ProductCatalog catalog=supplier.getProductCatalog();
       for(Product product:catalog.getProductCatalog())
       {
           System.out.println("tHE NAME OF PRODUCT"+product.getProductName());
       }
   }
    public static void AddMarket(MarketList marketList)
    {
        Market marketA=marketList.addMarket();
      marketA.setMarketName("MarketA");
      Market marketB=marketList.addMarket();
      marketB.setMarketName("MarketB");
      Market marketC=marketList.addMarket();
      marketC.setMarketName("MarketC");
      Market marketD=marketList.addMarket();
      marketD.setMarketName("MarketD");
      Market marketE=marketList.addMarket();
      marketE.setMarketName("MarketE");
    }
    
     public static void configProducts(Supplier supplier)
    {
        
        String csvFile = "Projects.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            while ((line = br.readLine()) != null) {
                Product product=supplier.getProductCatalog().addProduct();
                String[] CustomerList = line.split(cvsSplitBy);
                String customerName =CustomerList[0];
                String customerAddress =CustomerList[1];
                float price = Float.valueOf(customerAddress);
                product.setProductName(customerName);
                product.setProductValue(price);
                } 
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
     public static void configSalesPersons(SalesPersonDirectory spd)
    {
       
        String csvFile = ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            while ((line = br.readLine()) != null) {
                SalesPerson sp= spd.addSalesPerson();
                
                String[] CustomerList = line.split(cvsSplitBy);
                String customerName =CustomerList[0];
                System.out.println(customerName);
                sp.setSalesPersonName(customerName);
                } 
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    
    
    
    
    public static void configCustomers(Market market,int i)
    {
       
        String csvFile = "Customer.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            while ((line = br.readLine()) != null) {
                Customer customer=market.addCustomer();
                
                String[] CustomerList = line.split(cvsSplitBy);
                String customerName =CustomerList[0]+String.valueOf(i);
                System.out.println(customerName);
                String customerAddress =CustomerList[1];
                customer.setCustomerName(customerName);
                customer.setAddress(customerAddress);
                } 
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void ConfigMarket(MarketList marketList)
    {
        AddMarket(marketList);
        int i=1;
        for(Market market: marketList.getMarketList())
        {
          
            configCustomers(market,i);  
             i=i+1;
             System.out.println("i equals"+i);
        }
       
        }
        
        
        
        
    
    public static String getName()
    {
        
       char cha[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
       char chb[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
       char ch[] =new char[6];
       int index0=(int)(Math.random()*(cha.length));
       ch[0]=cha[index0];
       for(int i=1;i<ch.length;i++)
      {
         int index;
         index=(int)(Math.random()*(chb.length));
         ch[i]=chb[index];
      }
       String s = new String(ch);
        return s;
    }
     public static String getPassWord()
    {
        
       char cha[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
       char ch[] =new char[5];
       for(int i=0;i<ch.length;i++)
      {
         int index;
         index=(int)(Math.random()*(cha.length));
         ch[i]=cha[index];
      }
       String s = new String(ch);
        return s;
    }
}