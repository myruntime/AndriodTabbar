package com.app.zhl.demo.Tools;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.app.zhl.demo.R;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;


/**
 * ================================================
 * 上海建业信息科技股份有限公司  点账 Dome
 * 日 期： 2016/6/22 9:51
 * 作 者：Dove
 * =================================================
 **/
public class GlideImageLoad {

    /**
     * 加载网络图片
     * 转成圆形
     *
     * @param activity
     * @param url
     * @param imageView
     */
    public static void setClircleImage(FragmentActivity activity, String url, ImageView imageView) {
        setImage(activity, url)//加载路径
                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
                .placeholder(R.mipmap.jugg)//占位
                .crossFade()//淡入淡出动画效果
                .centerCrop()//图片显示样式
                .transform(new GlideCircleTransform(activity))//自定义Image
                .into(imageView);
    }

    /**
     * 加载网络图片
     * 设置圆角
     * @param fragmentActivity
     * @param url
     * @param imageView
     */
    public static void setRoundImage(FragmentActivity fragmentActivity, String url, ImageView imageView) {
        setImage(fragmentActivity, url)//加载路径
                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
                .placeholder(R.mipmap.jugg)//占位
                .crossFade()//淡入淡出动画效果
                .centerCrop()//图片显示样式
                .transform(new GlideCircleTransform(fragmentActivity))//自定义Image
                .into(imageView);
    }

    public static void setImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
                .placeholder(R.mipmap.jugg)//占位
                .crossFade()//淡入淡出动画效果
                .centerCrop()
                .into(imageView);
    }

    public static void setImageUri(Context context, Uri url, ImageView imageView) {
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
                .placeholder(R.mipmap.jugg)//占位
                .crossFade()//淡入淡出动画效果
                .into(imageView);
    }

    public static void setImageInteger(Context context, Integer integer, ImageView imageView) {
        Glide.with(context).load(integer)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
                .placeholder(R.mipmap.jugg)//占位
                .crossFade()//淡入淡出动画效果
                .into(imageView);
    }

    public static void setImageFile(Context context, File file, ImageView imageView) {
        Glide.with(context).load(file)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
                .placeholder(R.mipmap.jugg)//占位
                .crossFade()//淡入淡出动画效果
                .into(imageView);
    }

    public static DrawableTypeRequest<File> setImage(Context context, File file) {
        return Glide.with(context).load(file);
    }

    public static DrawableTypeRequest<Integer> setImage(Context context, Integer integer) {
        return Glide.with(context).load(integer);
    }

    public static DrawableTypeRequest<Uri> setImage(Context context, Uri uri) {
        return Glide.with(context).load(uri);
    }

    public static DrawableTypeRequest<String> setImage(Activity activity, String url) {
        return Glide.with(activity).load(url);
    }

    public static DrawableTypeRequest<File> setImage(Activity activity, File file) {
        return Glide.with(activity).load(file);
    }

    public static DrawableTypeRequest<Integer> setImage(Activity activity, Integer integer) {
        return Glide.with(activity).load(integer);
    }

    public static DrawableTypeRequest<Uri> setImage(Activity activity, Uri uri) {
        return Glide.with(activity).load(uri);
    }

    public static DrawableTypeRequest<String> setImage(FragmentActivity fragmentActivity, String url) {
        return Glide.with(fragmentActivity).load(url);
    }

    public static DrawableTypeRequest<File> setImage(FragmentActivity fragmentActivity, File file) {
        return Glide.with(fragmentActivity).load(file);
    }

    public static DrawableTypeRequest<Integer> setImage(FragmentActivity fragmentActivity, Integer integer) {
        return Glide.with(fragmentActivity).load(integer);
    }

    public static DrawableTypeRequest<Uri> setImage(FragmentActivity fragmentActivity, Uri uri) {
        return Glide.with(fragmentActivity).load(uri);
    }

    public static DrawableTypeRequest<String> setImage(Fragment fragment, String url) {
        return Glide.with(fragment).load(url);
    }

    public static DrawableTypeRequest<File> setImage(Fragment fragment, File file) {
        return Glide.with(fragment).load(file);
    }

    public static DrawableTypeRequest<Integer> setImage(Fragment fragment, Integer integer) {
        return Glide.with(fragment).load(integer);
    }

    public static DrawableTypeRequest<Uri> setImage(Fragment fragment, Uri uri) {
        return Glide.with(fragment).load(uri);
    }


    //方法一，加载圆形图片
//        Glide.with(this)
//                .load(HttpConstants.SHJYSOFT_URL + info.getPhoto_path())//加载路径
//                .asBitmap()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
//                .placeholder(R.drawable.login_qq_normal)//占位
//                .centerCrop()//图片显示样式
//                .into(new BitmapImageViewTarget(mIvHeadA) {
//                    @Override
//                    protected void setResource(Bitmap resource) {
//                        RoundedBitmapDrawable circularBitmapDrawable =
//                                RoundedBitmapDrawableFactory.create(getResources(), resource);
//                        circularBitmapDrawable.setCircular(true);
//                        mIvHeadA.setImageDrawable(circularBitmapDrawable);
//                    }
//                });//在哪个控件上显示
    //方法二  加载圆形图片
//        Glide.with(this)
//                .load(HttpConstants.SHJYSOFT_URL + info.getPhoto_path())//加载路径
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//全部缓存
//                .placeholder(R.drawable.login_qq_normal)//占位
//                .crossFade()//淡入淡出动画效果
//                .centerCrop()//图片显示样式
//                .transform(new GlideCircleTransform(this))//自定义Image
//                .into(mIvHeadA);
}
