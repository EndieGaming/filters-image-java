public class GuassianBlurFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData(); 
        int avgR = 0;
        int avgG = 0;
        int avgB = 0;
        for (int row = 1; row < data.length-1; row++) {
            for (int col = 1; col < data[row].length-1; col++) {
                for(int i = 0; i<3; i++){
                    //TOP
                    avgR+=data[row-1][col-1+i].getRed();
                    avgG+=data[row-1][col-1+i].getGreen();
                    avgB+=data[row-1][col-1+i].getBlue();
                    //RIGHT
                    avgR+=data[row-1+i][col+1].getRed();
                    avgG+=data[row-1+i][col+1].getGreen();
                    avgB+=data[row-1+i][col+1].getBlue();
                    //BOTTOM
                    avgR+=data[row+1][col-1+i].getRed();
                    avgG+=data[row+1][col-1+i].getGreen();
                    avgB+=data[row+1][col-1+i].getBlue();
                    //LEFT
                    avgR+=data[row-1+i][col-1].getRed();
                    avgG+=data[row-1+i][col-1].getGreen();
                    avgB+=data[row-1+i][col-1].getBlue();
                }
                avgR=avgR/16;
                avgG=avgG/16;
                avgB=avgB/16;
                data[row][col].setRed(avgR);
                data[row][col].setGreen(avgG);
                data[row][col].setBlue(avgB);
            }
        }
        pi.setData(data);
    }
}