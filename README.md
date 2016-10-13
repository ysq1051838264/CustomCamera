# CustomCamera
自定义相机,有聚焦、闪光灯、以及连续拍照、查看等功能

![alt tag](https://raw.githubusercontent.com/ysq1051838264/CustomCamera/master/1.jpg

###Camera控制拍照的过程

调用Camera的open()方法打开相机。

调用Camera的getParameters（）获取拍照参数，该方法返回一个Cmera.Parameters对象。

调用Camera.Parameters对象对照相的参数进行设置。

调用Camera的setParameters（），并将Camera.Parameters对象作为参数传入，这样就可以对拍照进行参数控制，Android2.3.3以后不用设置。

调用Camerade的startPreview()的方法开始预览取景，在之前需要调用Camera的setPreviewDisplay(SurfaceHolder holder)设置使用哪个SurfaceView来显示取得的图片。

调用Camera的takePicture()方法进行拍照。

程序结束时，要调用Camera的stopPreview()方法停止预览，并且通过Camera.release()来释放资源。


**[DownLoad Apk](https://github.com/ysq1051838264/CustomCamera/blob/master/apk/CustomCamera.apk?raw=true)**
