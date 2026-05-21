import java.util.ArrayList;

public class MarketItem{
    private String name;
    private String symbol;
    private double startPrice;
    private double currentPrice;
    private double volatility;
    
    private ArrayList<Double> priceHistory;
    
    public MarketItem(String name, String symbol, double startPrice, double volatility){
        
        
        this.name = name;
        this.symbol= symbol;
        this.startPrice = startPrice;
        this.currentPrice = startPrice;
        this.volatility = volatility;
        
        priceHistory = new ArrayList<>();
        priceHistory.add(startPrice);
        
    }
    
    
    public void updatePrice(){
        double percentChange = (Math.random() * (volatility *2))-volatility;
        
        currentPrice +=currentPrice * (percentChange /100.0);
        
        if(currentPrice< 0){
            
            currentPrice = 0.01;
            
            
        }
        
        priceHistory.add(currentPrice);
        
    }
    
    public double getPercentChange(){
        return ((currentPrice - startPrice) / startPrice) * 100;
    }
    
    public double getHighestPrice(){
        double highest = priceHistory.get(0);
        
        for (double price : priceHistory){
            if(price>highest){
                highest =  price;
            }
        }
        return highest;
    }
    
    
   public double getLowestPrice(){
       double lowest = priceHistory.get(0);
       
       for(double price : priceHistory){
           if(price<lowest){
               lowest =price;
           }
       }
       
       return lowest;
   } 
    
    
    public void displayReport(){
        
        System.out.printf(
            "| %-12s | %-6s | $%10.2f | $%10.2f | %9.2f%% | \n",
            name,
            symbol,
            startPrice,
            currentPrice,
            getPercentChange()
            
            );
    }
    
    
    public void displayDetailedStats(){
        System.out.println("-------------------------------");
        System.out.println(name + " (" + symbol + ")");
        System.out.printf("Start Price : $%.2f\n", startPrice);
        System.out.printf("Current     : $%.2f\n", currentPrice);
        System.out.printf("Highest     : $%.2f\n", getHighestPrice());
        System.out.printf("Lowest      : $%.2f\n", getLowestPrice());
        System.out.printf("Total Change: %.2f%%\n", getPercentChange());
         
          
            System.out.print("Price History: ");
        
        for(double price : priceHistory){
              System.out.printf("$%.2f ", price);
        }
        System.out.println();
        
    }
    
    public String getName(){
        return name;
        
    }
    
    
    public String getSymbol(){
        return symbol;
    }
    
    
    
    
    
}
