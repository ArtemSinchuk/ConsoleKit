
public class ProgressbarTest {
  private static char fullBlock = '\u2588';
  private static char emptyBlock = '\u2591';
  private static char[] sizeSymbols = {' ', '*', '=', '\u2593'};

  
  
  public static void main(String[] args) throws InterruptedException {

    ConsoleProgressBar progressBar = new ConsoleProgressBar();
    progressBar.printProgress(10, 50);
    progressBar.runProgressBar();
    System.out.println("\nProgress bar completed.");
    System.out.println();
  }
}