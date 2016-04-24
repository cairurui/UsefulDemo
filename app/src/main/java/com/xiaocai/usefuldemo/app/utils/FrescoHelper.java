package com.xiaocai.usefuldemo.app.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.base.BaseApplication;
import com.xiaocai.usefuldemo.app.wiget.LoadingProgressDrawable;

public class FrescoHelper {
	//默认加载图片和失败图片
  public static Drawable sPlaceholderDrawable = new ColorDrawable(0x660000FF);//占位符  在没有加载完成时的背景图片
  public static Drawable sProgressBarDrawable = new LoadingProgressDrawable(BaseApplication.getContext());//下载进度图
  public static Drawable sErrorDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.error);//加载错误图

	/**
	 * 图像选项类-->可设置圆角
	 * @param isRound 是否圆角
	 * @param radius  圆角角度
	 * @return
	 */
	public static GenericDraweeHierarchy getImageViewHierarchy(Resources resources, boolean isRound, float radius) {
		GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(resources);
		builder.setFailureImage(sErrorDrawable,ScaleType.CENTER);
		builder.setPlaceholderImage(sPlaceholderDrawable);
		builder.setProgressBarImage(sProgressBarDrawable);
		builder.setFadeDuration(300);
		if (isRound) {
			RoundingParams roundingParams = RoundingParams.fromCornersRadius(radius);
			builder.setRoundingParams(roundingParams);
		}
		return builder.build();
	}

	/**
	 * 图像选项类-->可设置为圆形
	 * @param resources Resources
	 * @param isCircle 是否圆圈
	 */
	public static GenericDraweeHierarchy getImageViewHierarchy(Resources resources, boolean isCircle) {
		GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(resources);
		builder.setFailureImage(sErrorDrawable,ScaleType.CENTER);
		builder.setPlaceholderImage(sPlaceholderDrawable);
		builder.setFadeDuration(300);
		builder.setProgressBarImage(sProgressBarDrawable);
		if (isCircle) {
			RoundingParams circleParams = RoundingParams.asCircle();
			circleParams.setBorder(Color.BLUE, 1.0f);
			circleParams.setRoundAsCircle(true);
			builder.setRoundingParams(circleParams);
		}
		return builder.build();
	}



	/**
	 * DraweeController的设置
	 * @param uri 图片路径
	 * @param oldController DraweeView.getoldcontroller
	 * @param controllerListener 监听
	 * @return
	 */
	public static DraweeController getImageViewController(String uri, DraweeController oldController,
			ControllerListener<ImageInfo> controllerListener) {
		PipelineDraweeControllerBuilder builder = Fresco.newDraweeControllerBuilder();
		if (!TextUtils.isEmpty(uri)) {
			builder.setUri(Uri.parse(uri));
		}
		if (oldController != null) {
			builder.setOldController(oldController);
		}
		if (controllerListener != null) {
			builder.setControllerListener(controllerListener);
		}
		return builder.build();
	}

	/**
	 * 加载图片
	 * @param draweeView SimpleDraweeView
	 * @param uri  地址url
	 * @param isRound 是否是圆角
	 * @param radius 圆角的角弧度
	 */
	public static void displayImageview(SimpleDraweeView draweeView, String uri,boolean isRound, float radius) {
		draweeView.setHierarchy(getImageViewHierarchy(BaseApplication.getContext().getResources(), isRound, radius));
		draweeView.setController(getImageViewController(uri, draweeView.getController(), null));
	}

	/**
	 * 显示图片-->可选是否显示为圆形图片
	 * @param circle 显示是否圆形
	 */
	public static void displayImage2Cir(SimpleDraweeView draweeView, String uri,boolean circle) {
		draweeView.setHierarchy(getImageViewHierarchy(BaseApplication.getContext().getResources(), circle));
		if("".equals(uri)){
			uri = "res://drawable-hdpi/" + R.drawable.ic_launcher;
		}
		draweeView.setController(getImageViewController(uri, draweeView.getController(), null));
	}

	public static void displayImageResize(SimpleDraweeView view ,String url,int width,int height,float ratio){
		Uri uri = Uri.parse(url);
		view.setAspectRatio(ratio);
		ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
				.setResizeOptions(new ResizeOptions(width, height))
				.build();
		PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
				.setOldController(view.getController())
				.setImageRequest(request)
				.build();
		view.setController(controller);
	}
}
