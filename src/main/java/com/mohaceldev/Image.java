package com.mohaceldev;

import org.bytedeco.opencv.global.opencv_highgui;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Point;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;

public class Image {
    public static void readImage(String imagePath) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Image not found");
        }

        imageInfo(image);

        opencv_highgui.imshow("Original Image", image);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void resizeImage(String imagePath, int resizePercentage) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Image not found");
        }

        imageInfo(image);

        opencv_imgproc.resize(image, image, new Size((int) (image.arrayWidth() / 100) * resizePercentage, (int) (image.arrayHeight() / 100) * resizePercentage));
        opencv_highgui.imshow("Resize Image", image);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void cropImage(String imagePath, int x, int y, int width, int height) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        // Check if the image is loaded successfully
        if (image.empty()) {
            System.err.println("Failed to load image: " + imagePath);
        }

        imageInfo(image);

        // Define the cropping region (x, y, width, height)
        Rect cropRegion = new Rect(x, y, width, height);

        // Crop the image
        Mat croppedImage = new Mat(image, cropRegion);

        opencv_highgui.imshow("Crop Image", croppedImage);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void imageInfo(Mat image) {
        System.out.println("Width: " + image.arrayWidth());
        System.out.println("Height: " + image.arrayHeight());
        System.out.println("Channel: " + image.channels());
    }

    public static void drawShapeText(String imagePath) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Failed to load image: " + imagePath);
        }

        // Draw a rectangle (top-left corner (50, 50), bottom-right corner (200, 200), color (0, 255, 0), thickness 2)
        opencv_imgproc.rectangle(image, new Point(50, 50), new Point(200, 200), new Scalar(0, 255, 0, 0), 2, 0, 0);

        // Draw a circle (center (300, 300), radius 50, color (255, 0, 0), thickness 2)
        opencv_imgproc.circle(image, new Point(300, 300), 50, new Scalar(255, 0, 0, 0), 2, 0, 0);

        // Draw a line (from (400, 400) to (500, 500), color (0, 0, 255), thickness 2)
        opencv_imgproc.line(image, new Point(400, 400), new Point(500, 500), new Scalar(0, 0, 255, 0), 2, 0, 0);

        // Draw text (text "Hello, JavaCV!", bottom-left corner (100, 100), font scale 1.0, color (255, 255, 255), thickness 2)
        opencv_imgproc.putText(image, "Hello, JavaCV!", new Point(100, 100), opencv_imgproc.FONT_HERSHEY_SIMPLEX, 1.0, new Scalar(255, 255, 255, 0), 2, opencv_imgproc.LINE_AA, false);


        opencv_highgui.imshow("Image", image);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void drawRectangle(String imagePath, int left, int top, int right, int bottom, int blue, int green, int red, double alpha) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Failed to load image: " + imagePath);
        }

        opencv_imgproc.rectangle(image, new Rect(left, top, right, bottom), new Scalar(red, green, blue, alpha));

        opencv_highgui.imshow("Original Image", image);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void drawCircle(String imagePath, int x, int y, int radius, int blue, int green, int red, double alpha, int thickness) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Failed to load image: " + imagePath);
        }

        // Draw a circle (center (300, 300), radius 50, color (255, 0, 0), thickness 2)
        opencv_imgproc.circle(image, new Point(x, y), radius, new Scalar(blue, green, red, alpha), thickness, 0, 0);

        opencv_highgui.imshow("Image", image);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void putText(String imagePath, String text, int x, int y, int fontFace, double fontScale, int blue, int green, int red, double alpha) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Failed to load image: " + imagePath);
        }

        opencv_imgproc.putText(image, text, new Point(x, y), fontFace, fontScale, new Scalar(blue, green, red, alpha));
        opencv_highgui.imshow("Image", image);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

    public static void edgeDetection(String imagePath, double lowerThreshold, double upperThreshold) {
        Mat image = opencv_imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.err.println("Failed to load image: " + imagePath);
        }

        Mat grayImage = new Mat();
        opencv_imgproc.cvtColor(image, grayImage, opencv_imgproc.COLOR_BGR2GRAY);

        Mat blurImage = new Mat();
        opencv_imgproc.GaussianBlur(grayImage, blurImage, new Size(3, 3), 0);

        Mat edge = new Mat();
        opencv_imgproc.Canny(blurImage, edge, lowerThreshold, upperThreshold);

        opencv_highgui.imshow("Edge Image", edge);
        opencv_highgui.waitKey(0);
        opencv_highgui.destroyAllWindows();
    }

}
