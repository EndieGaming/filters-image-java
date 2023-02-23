
 class NegativeImageFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();    
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int tempR = 255-data[row][col].getRed();
                int tempG = 255-data[row][col].getGreen();
                int tempB = 255-data[row][col].getBlue();
                data[row][col].setRed(tempR);
                data[row][col].setGreen(tempG);
                data[row][col].setBlue(tempB);
            }
        }
        pi.setData(data);
    }
}