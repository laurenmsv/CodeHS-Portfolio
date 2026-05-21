
import java.util.ArrayList;
import java.util.Scanner;

public class MarketManiaSimulator {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        ArrayList<MarketItem> market = new ArrayList<>();
        
        System.out.println("================================");
        System.out.println("     Market Mania Simulator    ");
        System.out.println("================================");
        
        market.add(new MarketItem("Bitcoin", "BTC", 45000,8));
        market.add(new MarketItem("Ethereum", "ETH", 3200,6));
        market.add(new MarketItem("Tesla", "TSLA", 210,5));
        market.add(new MarketItem("Apple", "AAPL", 180,3));
        market.add(new MarketItem("NVIDIA", "NVDA", 900,7));
        
        
        System.out.println("How many custom assets would you like to add?");
        int customAssets = input.nextInt();
        input.nextLine();
        
        for(int i = 1;i<=customAssets;i++){
            
            System.out.println("\nCustom asset #" +i);
            
            System.out.print("Asset name: ");
            String name = input.nextLine();
            
            System.out.print("Symbol: ");
            String symbol= input.nextLine();
            
           System.out.print("Starting price: "); 
            double startPrice =input.nextDouble();
            
            System.out.print("volatility (%): ");
            double volatility = input.nextDouble();
            input.nextLine();
            
            market.add(new MarketItem(name,symbol,startPrice,volatility));
            
            
        }
        
        
        
        System.out.println();
        
System.out.println("How many days should the market run?");
        int days = input.nextInt();
        
        for (int day =1;day<=days;day++){
        
        System.out.println("\n==============================");
        System.out.println("            Day " + day);
        System.out.println("==============================");
        
        for(MarketItem item : market){
            item.updatePrice();
            
            
            
            System.out.printf(
                "%-12s(%-5s) updated successfuly. \n",
            item.getName(),
            item.getSymbol()
            );
        }
    }

        
    System.out.println("===============================");
    System.out.println("      Final Market Report  ");
    System.out.println("===============================");
    
    System.out.printf(
        "| %-12s| %-6s| %-12s | %-12s |%-10s |\n",
        "asset", "symbol","start price", "current","change"
        );
        
        
    System.out.println("----------------------------------");

        
        for(MarketItem item : market){
            item.displayReport();
        }
        
        System.out.println("=====================================");
        
        System.out.println("\nDetailed Asset Statistics");
        
        for(MarketItem item: market){
            item.displayDetailedStats();
        }
        
   input.close();     
        
        
    }
}
