import java.io.File;
import java.io.FileNotFoundException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(final String[] args) throws FileNotFoundException {
        
        final File inputFile = new File(args[0]);
        final Scanner inputData = new Scanner(inputFile);
        Trie tree = new Trie();
        while (inputData.hasNextLine()) {
            final String str = inputData.nextLine();
            if (str.length() > 1) {
                tree.insert(str.toLowerCase());
            }
        }
        tree.compress();
        tree.display();
    }
    private static long peakMemoryUsage() {

    List<MemoryPoolMXBean> pools = ManagementFactory.getMemoryPoolMXBeans();
    long total = 0;
    for (MemoryPoolMXBean memoryPoolMXBean : pools) {
        if (memoryPoolMXBean.getType() == MemoryType.HEAP) {
            long peakUsage = memoryPoolMXBean.getPeakUsage().getUsed();
            // System.out.println("Peak used for: " + memoryPoolMXBean.getName() + " is: " + peakUsage);
            total = total + peakUsage;
        }
    }
    return total;
    }
}
