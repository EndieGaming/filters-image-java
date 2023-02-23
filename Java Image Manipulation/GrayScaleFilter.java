public class GrayScaleFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();    
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int tempR = data[row][col].getRed();
                int tempG = data[row][col].getGreen();
                int tempB = data[row][col].getBlue();
                int avg = (tempR+tempG+tempB)/3;
                data[row][col].setRed(avg);
                data[row][col].setGreen(avg);
                data[row][col].setBlue(avg);
            }
        }
        pi.setData(data);
    }
}