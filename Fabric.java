/**
 * Fabric class -  plain woven fabric
 *  warp/weft yarns, thread counts - fabric weight (gsm), cover factor, comfort.
 */
public class Fabric {

    private Yarn warpYarn;          // yarns length
    private Yarn weftYarn;          // yarns width
    private int warpEndsPerInch;    // thread density (warp)
    private int weftPicksPerInch;   // thread density (weft)

    // Constructor
    public Fabric(Yarn warpYarn, Yarn weftYarn, int warpEndsPerInch, int weftPicksPerInch) {
        this.warpYarn = warpYarn;
        this.weftYarn = weftYarn;
        this.warpEndsPerInch = warpEndsPerInch;
        this.weftPicksPerInch = weftPicksPerInch;
    }

    // Fabric weight GSM
    public double calculateGsm() {
        double warpContribution = warpYarn.getTex() * warpEndsPerInch;
        double weftContribution = weftYarn.getTex() * weftPicksPerInch;
        double totalGsm = (warpContribution + weftContribution) * 0.254; // in to cm conversion
        return Math.round(totalGsm * 10.0) / 10.0; // 1 decimal
    }

    // Cover factor %
    public double calculateCoverFactor() {
        double warpCover = warpYarn.getDiameterMm() * warpEndsPerInch;
        double weftCover = weftYarn.getDiameterMm() * weftPicksPerInch;
        double averageCover = (warpCover + weftCover) / 2.0;
        return Math.min(averageCover * 100.0, 110.0); // cap at 110%
    }

    // Comfort index (0–100) - lighter and more open is more comfortable
    public double calculateComfortIndex() {
        double gsm = getGsm();
        double cover = getCoverFactor();

        double weightScore = Math.max(0, 100 - (gsm / 4.0));      // very heavy - low score
        double opennessScore = Math.max(0, 100 - (cover - 50));   // higher cover - lower score

        double comfort = (weightScore + opennessScore) / 2.0;
        return Math.round(comfort * 10.0) / 10.0;
    }

    // Print full fabric analysis
    public void analyze() {
        System.out.printf("Fabric Analysis:%n");
        System.out.printf("  Warp: %s (%.1f tex, %d ends/in)%n",
                warpYarn.getMaterialType(), warpYarn.getTex(), warpEndsPerInch);
        System.out.printf("  Weft: %s (%.1f tex, %d picks/in)%n",
                weftYarn.getMaterialType(), weftYarn.getTex(), weftPicksPerInch);
        System.out.printf("  Weight: %.0f gsm (light/medium/heavy)%n", calculateGsm());
        System.out.printf("  Cover: %.0f%% (open/tight)%n", calculateCoverFactor());
        System.out.printf("  Comfort: %.0f/100%n", calculateComfortIndex());
        System.out.printf("  Use case: %s%n", getUseCase());
    }

    private String getUseCase() {
        double gsm = calculateGsm();
        if (gsm < 100) return "light summer shirt";
        else if (gsm < 200) return "shirt/dress";
        else return "jacket/upholstery";
    }

    // Getters
    public double getGsm() { return calculateGsm(); }
    public double getCoverFactor() { return calculateCoverFactor(); }

    // Validate realistic inputs
    public boolean isValid() {
        return warpEndsPerInch > 0 && weftPicksPerInch > 0
                && warpEndsPerInch < 200 && weftPicksPerInch < 200;
    }

    // Compare this fabric vs another
    public String compareTo(Fabric other) {
        double gsmDiff = Math.abs(this.getGsm() - other.getGsm());
        if (gsmDiff < 20) {
            return "SIMILAR weight – either works";
        } else if (this.getGsm() < other.getGsm()) {
            return "LIGHTER (" + (int) this.getGsm() + "gsm vs " + (int) other.getGsm() + "gsm)";
        } else {
            return "HEAVIER (" + (int) this.getGsm() + "gsm vs " + (int) other.getGsm() + "gsm)";
        }
    }

    //  recommendation
    public String getRecommendation() {
        double gsm = getGsm();
        double cover = getCoverFactor();
        if (gsm < 120 && cover > 70) return "Summer activewear";
        if (gsm < 200) return "Dress shirt";
        if (gsm < 300) return "Light jacket";
        return "Industrial/upholstery";
    }
}
