import java.util.Scanner;

/**
 */
public class TextileLabMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Textile Lab v0.5 - FABRIC BATTLE");
        System.out.println("Design Fabric 1:");
        Fabric fabric1 = getFabricFromInput(scanner, 1);
        
        System.out.println("\nDesign Fabric 2:");
        Fabric fabric2 = getFabricFromInput(scanner, 2);
        
        // compare
        System.out.println("\nFABRIC BATTLE RESULTS");
        System.out.println("FABRIC 1:");
        fabric1.analyze();
        System.out.println("\nFABRIC 2:");  
        fabric2.analyze();
        
        System.out.println("\nCOMPARISON:");
        System.out.println("Fabric 1 vs 2: " + fabric1.compareTo(fabric2));
        System.out.println("Fabric 2 vs 1: " + fabric2.compareTo(fabric1));
        System.out.println("\nRECOMMENDATIONS:");
        System.out.println("Fabric 1: " + fabric1.getRecommendation());
        System.out.println("Fabric 2: " + fabric2.getRecommendation());
        
        scanner.close();
    }
    
    // Helper: get one fabric from user input
    private static Fabric getFabricFromInput(Scanner scanner, int num) {
        System.out.printf("Fabric %d - Warp specs:%n", num);
        System.out.print("  Diameter (mm): ");
        double warpDia = scanner.nextDouble();
        System.out.print("  Density (g/cm³): ");
        double warpDensity = scanner.nextDouble();
        System.out.print("  Ends/inch: ");
        int warpEnds = scanner.nextInt();
        
        System.out.printf("Fabric %d - Weft specs:%n", num);
        System.out.print("  Diameter (mm): ");
        double weftDia = scanner.nextDouble();
        System.out.print("  Density (g/cm³): ");
        double weftDensity = scanner.nextDouble();
        System.out.print("  Picks/inch: ");
        int weftPicks = scanner.nextInt();
        
        Yarn warp = new Yarn(warpDia, warpDensity, "warp");
        Yarn weft = new Yarn(weftDia, weftDensity, "weft");
        Fabric fabric = new Fabric(warp, weft, warpEnds, weftPicks);
        
        if (!fabric.isValid()) {
            System.out.println("Warning: Unrealistic densities");
        }  
        return fabric;
    }
}
