package com.mohaceldev;

public class Main {
    public static void main(String[] args) {
        String imagePath = "/home/mohacel/opencv-practice/code/cv/src/main/resources/images/edgeflower.jpg";
//        Image.readImage(imagePath);
//        Image.resizeImage(imagePath, 40);
//        Image.cropImage(imagePath, 50, 50, 200, 200);
//        Image.drawShapeText(imagePath);
//        Image.drawRectangle(imagePath, 50,0, 150,200,0,0,255,0.3);
//        Image.drawCircle(imagePath, 250, 250, 120, 0, 255, 0, 0.1,2);
//        Image.putText(imagePath, "Hello, Flower", 50,150, 3,2,0,255,0,0);
        Image.edgeDetection(imagePath, 19.0, 120.0);
    }
}