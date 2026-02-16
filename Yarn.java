/**
 * Yarn class -  textile yarn 
 * metrics - diameter, material and linear density
 */
public class Yarn {
    
    // Fields 
    private double diameterMm;  // yarn diameter 
    private double materialDensityGcm3;  // material density 
    private String materialType;  // cotton, polyester, etc.
    
    // Constructor
    public Yarn(double diameterMm, double materialDensityGcm3, String materialType) {
        this.diameterMm = diameterMm;
        this.materialDensityGcm3 = materialDensityGcm3;
        this.materialType = materialType;
    }
    
    // Calculate linear density in tex
    public double calculateTex() {
        // formula:
        // Tex = (π × (d/2)^2 × materialDensity × 1000) / 1000
        // OR - π × r² × density
        double radiusCm = diameterMm / 20.0;  // mm to cm (/10) - radius (/2)
        double crossSectionCm2 = Math.PI * radiusCm * radiusCm;
        double tex = crossSectionCm2 * materialDensityGcm3 * 1000000.0;  // cm² → m²
        return Math.round(tex * 100.0) / 100.0;  // Round 2 decimals
    }
    
    // Getters
    public double getDiameterMm() { return diameterMm; }
    public double getMaterialDensityGcm3() { return materialDensityGcm3; }
    public String getMaterialType() { return materialType; }
    public double getTex() { return calculateTex(); }
    
    // Print yarn specs
    public void printSpecs() {
        System.out.printf("Yarn: %s, D=%.2fmm, Density=%.2fg/cm³, TEX=%.1f%n", 
                         materialType, diameterMm, materialDensityGcm3, calculateTex());
    }
}
