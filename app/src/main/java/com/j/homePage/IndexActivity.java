package com.j.homePage;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.j.R;
import com.j.activity.ExpandableListActivityTest;
import com.j.activity.ForResult;
import com.j.activity.Hello;
import com.j.activity.LifeCycle;
import com.j.activity.PreferenceActivityTest;
import com.j.activity.TabActivityTest;
import com.j.amap.AMapActivity;
import com.j.contacts.CallRecordActivity;
import com.j.contacts.ContactsActivity;
import com.j.contacts.ContactsActivity2;
import com.j.contacts.ContactsInAllActivity;
import com.j.contacts.SmsRecordActivity;
import com.j.contacts.TestDrawActivity;
import com.j.db_io.file.FileTest;
import com.j.db_io.file.SDFileExplorer;
import com.j.db_io.file.SdFileTest;
import com.j.db_io.gesture.AddGesture;
import com.j.db_io.gesture.GestureFlip;
import com.j.db_io.gesture.GestureTest;
import com.j.db_io.gesture.GestureZoom;
import com.j.db_io.gesture.RecogniseGesture;
import com.j.db_io.sharedPreferences.ReadOtherPreferences;
import com.j.db_io.sharedPreferences.SharedPreferencesActivity;
import com.j.db_io.sharedPreferences.UseCountActivity;
import com.j.db_io.sqlite.SqliteTest;
import com.j.db_io.sqliteOpenHelper.DictActivity;
import com.j.db_io.tts.TextToSpeechTest;
import com.j.fragment.book.BookFragmentTest;
import com.j.fragment.news.NewsActivity;
import com.j.fragment.simple.SimpleFragmentTest;
import com.j.images.AnimationPandaActivity;
import com.j.images.BitAssetManagerActivity;
import com.j.images.BitmapBrowserActivity;
import com.j.images.BlastActivity;
import com.j.images.CanvasViewTest;
import com.j.images.HandDrawTest;
import com.j.images.PinBallActivity;
import com.j.images.PlaneActivity;
import com.j.intent.ActionAttrTest;
import com.j.intent.ActionCategoryAttrTest;
import com.j.intent.ActionDataTest;
import com.j.intent.ComponentAttrTest;
import com.j.intent.DataTypeOverrideTest;
import com.j.intent.IntentsTest;
import com.j.intent.ReturnHomeActivity;
import com.j.intent.SysActionTest;
import com.j.intent.tab.IntentTabTest;
import com.j.media.SoundPoolTest;
import com.j.media.VideoViewTest;
import com.j.opengl.PolygonTest;
import com.j.opengl.RotatePolygonTest;
import com.j.opengl.Simple3DTest;
import com.j.opengl.Texture3DTest;
import com.j.provider.ContactProviderActivity;
import com.j.provider.ContentObserverMonitorSMS;
import com.j.provider.FirstResolverActivity;
import com.j.provider.MediaProviderActivity;
import com.j.provider.dict.DictResolverActivity;
import com.j.receiver.MusicBox;
import com.j.receiver.MyReceiverTest;
import com.j.receiver.SortedBroadcastTest;
import com.j.receiver.sys.BatteryReceiver;
import com.j.sensor.CompassActivity;
import com.j.sensor.GradienterActivity;
import com.j.sensor.SensorActivity;
import com.j.service.BindServiceTest;
import com.j.service.FirstServiceTest;
import com.j.service.IntentServiceTest;
import com.j.service.aidl.AIDLClient;
import com.j.service.aidl.ComplexClient;
import com.j.service.alarmManager.AlarmTest;
import com.j.service.audioManager.AudioManagerTest;
import com.j.service.smsManager.GroupSendSms;
import com.j.service.smsManager.SendSms;
import com.j.service.telephonyManager.TelephonyManagerTest;
import com.j.service.vibrator.VibratorTest;
import com.j.ui.actionBar.ActionBarDropDownTest;
import com.j.ui.actionBar.ActionBarTabTest;
import com.j.ui.actionBar.ActionBarTest;
import com.j.ui.actionBar.ActionItemTest;
import com.j.ui.actionBar.ActionViewTest;
import com.j.ui.dialog.AlertDialogTest;
import com.j.ui.dialog.AlertDialogTest2;
import com.j.ui.dialog.DateTimePickerDialog;
import com.j.ui.dialog.DialogThemeTest;
import com.j.ui.dialog.PopupWindowTest;
import com.j.ui.dialog.PopupWindowTest2;
import com.j.ui.dialog.ProgressDialogTest;
import com.j.ui.hello.BallActivity;
import com.j.ui.hello.MixControlUIActivity;
import com.j.ui.hello.PureJavaUIActivity;
import com.j.ui.imageView.ImageButtonZoomButton;
import com.j.ui.imageView.ImageViewTest;
import com.j.ui.imageView.QuickContactBadgeTest;
import com.j.ui.layout.FrameLayoutActivity;
import com.j.ui.layout.GridLayoutActivity;
import com.j.ui.layout.LinearLayoutActivity;
import com.j.ui.layout.RelativeLayoutTest;
import com.j.ui.layout.RelativeLayoutTest2;
import com.j.ui.layout.RelativeLayoutTest3;
import com.j.ui.layout.TableLayoutActivity;
import com.j.ui.layout.TableLayoutActivity2;
import com.j.ui.listView.AdapterViewFlipperTest;
import com.j.ui.listView.AutoCompleteTextViewTest;
import com.j.ui.listView.ExpendableListViewTest;
import com.j.ui.listView.GridView_SimpleAdapter1;
import com.j.ui.listView.GridView_SimpleAdapter2;
import com.j.ui.listView.ListView_ArrayAdapter;
import com.j.ui.listView.ListView_BaseAdapter;
import com.j.ui.listView.ListView_Entries;
import com.j.ui.listView.ListView_SimpleAdapter;
import com.j.ui.listView.SpinnerTest;
import com.j.ui.listView.StackViewTest;
import com.j.ui.listView.extendsArrayAdapter.chat.MsgActivity;
import com.j.ui.listView.extendsArrayAdapter.fruit.FruitActivity;
import com.j.ui.menu.MenuTest;
import com.j.ui.miscellaneous.CalendarViewTest;
import com.j.ui.miscellaneous.DatePickerTimePicker;
import com.j.ui.miscellaneous.NotificationTest;
import com.j.ui.miscellaneous.NumberPickerTest;
import com.j.ui.miscellaneous.ScrollViewTest;
import com.j.ui.miscellaneous.SearchViewTest;
import com.j.ui.miscellaneous.TabHostTest;
import com.j.ui.miscellaneous.ToastTest;
import com.j.ui.progressBar.ProgressBarTest;
import com.j.ui.progressBar.SeekBarRatingBarTest;
import com.j.ui.progressBar.TitleProgressBarTest;
import com.j.ui.textViews.Analog_Digital_Clock;
import com.j.ui.textViews.Button9PatchTest;
import com.j.ui.textViews.ButtonTest;
import com.j.ui.textViews.ChronometerTest;
import com.j.ui.textViews.EditViewInputUITest;
import com.j.ui.textViews.RadioButton_CheckBox;
import com.j.ui.textViews.TextViewTest;
import com.j.ui.textViews.TextViewTest2;
import com.j.ui.textViews.ToggleButton_Switch;
import com.j.ui.viewAnimator.ImageSwitcherTest;
import com.j.ui.viewAnimator.TextSwitcherTest;

/**
 * Created by Administrator on 2015/7/15.
 */
public class IndexActivity extends LauncherActivity {
    String[] titles = new String[]{
            "hello android",
            "混合控制UI(简单图片浏览器)",
            "纯JAVA控制UI(简单按钮)",
            "自定义view(跟随手指的小球)",
            "LinearLayout:横排纵排切换",
            "TableLayout:各种布局测试",
            "TableLayout:九九乘法表",
            "FrameLayout:霓虹灯",
            "RelativeLayout:梅花布局",
            "RelativeLayout:相对parent布局",
            "RelativeLayout:相对Component布局",
            "GridLayout:计算器",
            "TextView1:不同颜色 字体 带连接",
            "TextView2:圆角边框 渐变背景",
            "EditViewInputUI",
            "button：普通 圆形 带文字的图片按钮",
            "button：9Patch图片做背景",
            "RadioButton_CheckBox:单选与多选",
            "ToggleButton_Switch",
            "Analog_Digital_Clock:手表和时钟",
            "chronometer:计时器",
            "ImageView图片浏览器",
            "ImageButtonZoomButton:缩放图片",
            "QuickContactBadge:关联联系人",
            "ListView_Entries",
            "ListView_ArrayAdapter",
            "ListView_SimpleAdapter",
            "ListView_BaseAdapter",
            "继承ArrayAdapter实现复杂ListView(Fruit)",
            "继承ArrayAdapter实现复杂ListView(Msg聊天室)",
            "AutoCompleteTextView:自动完成文本框",
            "GridView_SimpleAdapter1",
            "GridView_SimpleAdapter2",
            "ExpendableListView:可展开的列表组件,查看星际兵种",
            "Spinner:列表选择框",
            "AdapterViewFlipperTest:自动播放图片库",
            "StackView:堆叠图片",
            "ProgressBar:进度条",
            "TitleProgressBar:标题显示进度条",
            "SeekBar:拖动条 RatingBar:星级评定条",
            "TextSwitcher:文本切换器",
            "ImageSwitcher:支持动画的图片浏览器",
            "Toast:提示信息框",
            "CalendarView:日历视图",
            "DatePickerTimePicker:日期时间选择器",
            "NumberPicker:数值选择器",
            "SearchView:搜索框",
            "TabHost:选项卡",
            "ScrollView:可滚动视图",
            "Notification:通知",
            "AlertDialog:各种对话框",
            "DialogTheme:对话风格的窗口",
            "PopupWindow",
            "DateTimePickerDialog:日期时间选择器对话框",
            "ProgressDialog:进度条对话框",
            "MenuTest:菜单测试",
            "ActionBarTest:显示和隐藏actionBar菜单",
            "ActionItemTest:使用actionBar显示菜单选项",
            "ActionViewTest:actionView菜单",
            "ActionBarTab:用actionBar实现Tab导航",
            "ActionBarDropDownTest:用actionBar实现下拉Tab导航",
            "PreferenceActivity:设置程序参数",
            "ExpandableListActivity:查看星际兵种",
            "Activity生命周期",
            "TabActivity:分页-TabHost",
            "ForResult:用第二个activity让用户选择信息",
            "简单Fragment",
            "新闻客户端，适配多屏的Fragment",
            "显示图书详细信息的Fragment",
            "使用Intent在activity之间穿梭",
            "Intent的component属性",
            "Intent的action属性",
            "Intent的action和category属性",
            "ReturnHome:返回桌面",
            "指定action和category调用系统activity",
            "Intent的data与type属性覆盖关系",
            "指定action和data调用系统activity",
            "使用intent创建tab页面",
            "SharedPreferences:记录应用程序的使用次数",
            "SharedPreferences:读写",
            "读取其他程序的SharedPreferences",
            "android文件读取测试",
            "SD卡文件读写",
            "SD卡文件浏览",
            "Sqlite数据库读写",
            "sqliteOpenHelper:生词本",
            "TextToSpeech:自动朗读TTS",
            "Gesture:手势测试",
            "GestureZoom:通过手势缩放图片",
            "GestureFlip:通过手势实现翻页效果",
            "AddGesture:添加手势",
            "RecogniseGesture:识别手势",
            "FirstResolverActivity:使用ContentResolver调用方法",
            "使用ContentProvider共享生词本数据",
            "使用ContactProvider管理系统联系人",
            "浏览手机中的图片,ContentProvider",
            "ContentObserverMonitorSMS:监听用户发出的短信",
            "BindServiceTest:绑定本地service并与之通信",
            "IntentServiceTest：使用IntentService",
            "AIDLClient:客户端访问AIDL",
            "ComplexClient:传递复杂数据的AIDL Service",
            "发短信",
            "群发短信",
            "使用AudioManager控制音频",
            "Vibrator:振动器",
            "AlarmTest:闹钟测试",
            "MyReceiverTest:发送广播",
            "SortedBroadcastTest:发送有序广播",
            "MusicBox:基于service的音乐播放器",
            "VideoViewTest:播放视频",
            "水平仪gradienter",
            "指南针compass",
            "传感器sensor",
            "Texture3D，纹理贴图",
            "simple3D",
            "旋转多边形，OpenGL 2D",
            "多边形，OpenGL 2D",
            "soundPool测试",
            "手机电量提醒",
            "测试telephonyManager",
            "测试service",
            "theme_style展示",
            "浏览手机中的图片,遍历文件",
            "4种TestDraw绘画测试",
            "bitmap图片浏览器,AssetManager",
            "PopupWindow对话框-阻塞",
            "AlertDialog对话框-非阻塞",
            "模拟爆炸Blast",
            "弹球游戏",
            "手写板handDraw",
            "画布cavas",
            "高德地图",
            "打飞机游戏-重力传感器",
            "信息记录",
            "君子通讯录(ListView/ArrayAdapter)",
            "君子通讯录2(ListView/SimpleAdapter)",
            "通话记录",
            "360通讯录(Intent,TabActivity)",
            "熊猫动画"
    };

    Class<?>[] classes = new Class[]{
            Hello.class,  //hello android
            MixControlUIActivity.class,  //混合控制UI(简单图片浏览器)
            PureJavaUIActivity.class,  //纯JAVA控制UI(简单按钮)
            BallActivity.class,  //自定义view(跟随手指的小球)
            LinearLayoutActivity.class,  //LinearLayout:横排纵排切换
            TableLayoutActivity.class,  //TableLayout:各种布局测试
            TableLayoutActivity2.class,  //TableLayout:九九乘法表
            FrameLayoutActivity.class,  //FrameLayout:霓虹灯
            RelativeLayoutTest.class,  //RelativeLayout:梅花布局
            RelativeLayoutTest2.class,  //RelativeLayout:相对parent布局
            RelativeLayoutTest3.class,  //RelativeLayout:相对Component布局
            GridLayoutActivity.class,  //GridLayout:计算器
            TextViewTest.class,  //TextView1:不同颜色 字体 带连接
            TextViewTest2.class,  //TextView2:圆角边框 渐变背景
            EditViewInputUITest.class,  //EditViewInputUI
            ButtonTest.class,  //button：普通 圆形 带文字的图片按钮
            Button9PatchTest.class,  //button：9Patch图片做背景
            RadioButton_CheckBox.class,  //RadioButton_CheckBox:单选与多选
            ToggleButton_Switch.class,  //ToggleButton_Switch
            Analog_Digital_Clock.class,  //Analog_Digital_Clock:手表和时钟
            ChronometerTest.class,  //chronometer:计时器
            ImageViewTest.class,  //ImageView图片浏览器
            ImageButtonZoomButton.class,  //ImageButtonZoomButton:缩放图片
            QuickContactBadgeTest.class,  //QuickContactBadge:关联联系人
            ListView_Entries.class,  //ListView_Entries
            ListView_ArrayAdapter.class,  //ListView_ArrayAdapter
            ListView_SimpleAdapter.class,  //ListView_SimpleAdapter,
            ListView_BaseAdapter.class,  //ListView_BaseAdapter,
            FruitActivity.class,  //继承ArrayAdapter实现复杂ListView(Fruit)
            MsgActivity.class,  //继承ArrayAdapter实现复杂ListView(Msg聊天室)
            AutoCompleteTextViewTest.class,  //AutoCompleteTextView:自动完成文本框
            GridView_SimpleAdapter1.class,  //GridView_SimpleAdapter1
            GridView_SimpleAdapter2.class,  //GridView_SimpleAdapter2
            ExpendableListViewTest.class,  //ExpendableListView:可展开的列表组件,查看星际兵种
            SpinnerTest.class,  //Spinner:列表选择框
            AdapterViewFlipperTest.class,  //AdapterViewFlipperTest:自动播放图片库
            StackViewTest.class,  //StackView:堆叠图片
            ProgressBarTest.class,  //ProgressBar:进度条
            TitleProgressBarTest.class,  //TitleProgressBar:标题显示进度条
            SeekBarRatingBarTest.class, //SeekBar:拖动条 RatingBar:星级评定条
            TextSwitcherTest.class, //TextSwitcher:文本切换器
            ImageSwitcherTest.class,  //ImageSwitcher:支持动画的图片浏览器
            ToastTest.class,  //Toast:提示信息框
            CalendarViewTest.class,  //CalendarView:日历视图
            DatePickerTimePicker.class,  //DatePickerTimePicker:日期时间选择器
            NumberPickerTest.class,  //NumberPicker:数值选择器
            SearchViewTest.class,  //SearchView:搜索框
            TabHostTest.class,  //TabHost:选项卡
            ScrollViewTest.class,  //ScrollView:可滚动视图
            NotificationTest.class,  //Notification:通知
            AlertDialogTest.class,  //AlertDialog:各种对话框
            DialogThemeTest.class,  //DialogTheme:对话风格的窗口
            PopupWindowTest.class,  //PopupWindow
            DateTimePickerDialog.class,  //DateTimePickerDialog:日期时间选择器对话框
            ProgressDialogTest.class,  //ProgressDialog:进度条对话框
            MenuTest.class,  //MenuTest:菜单测试
            ActionBarTest.class,  //ActionBarTest:显示和隐藏actionBar菜单
            ActionItemTest.class,  //ActionItemTest:使用actionBar显示菜单选项
            ActionViewTest.class,  //ActionViewTest:actionView菜单
            ActionBarTabTest.class,  //ActionBarTab:用actionBar实现Tab导航
            ActionBarDropDownTest.class,  //ActionBarDropDownTest:用actionBar实现下拉Tab导航
            PreferenceActivityTest.class,  //PreferenceActivity:设置程序参数
            ExpandableListActivityTest.class,  //ExpandableListActivity:查看星际兵种
            LifeCycle.class,  //Activity生命周期
            TabActivityTest.class,  //TabActivity:分页-TabHost
            ForResult.class,  //ForResult:用第二个activity让用户选择信息
            SimpleFragmentTest.class,  //简单Fragment
            NewsActivity.class,  //新闻客户端，适配多屏的Fragment
            BookFragmentTest.class,  //显示图书详细信息的Fragment
            IntentsTest.class,  //使用Intent在activity之间穿梭
            ComponentAttrTest.class,  //Intent的component属性
            ActionAttrTest.class,  //Intent的action属性
            ActionCategoryAttrTest.class,  //Intent的action和category属性
            ReturnHomeActivity.class,  //ReturnHome:返回桌面
            SysActionTest.class,  //指定action和category调用系统activity
            DataTypeOverrideTest.class,  //Intent的data与type属性覆盖关系
            ActionDataTest.class,  //指定action和data调用系统activity
            IntentTabTest.class,  //使用intent创建tab页面
            UseCountActivity.class,  //SharedPreferences:记录应用程序的使用次数
            SharedPreferencesActivity.class,  //SharedPreferences:读写
            ReadOtherPreferences.class,  //读取其他程序的SharedPreferences
            FileTest.class,  //android文件读取测试
            SdFileTest.class,  //SD卡文件读写
            SDFileExplorer.class,  //SD卡文件浏览
            SqliteTest.class,  //Sqlite数据库读写
            DictActivity.class,  //sqliteOpenHelper:生词本
            TextToSpeechTest.class,  //TextToSpeech:自动朗读TTS
            GestureTest.class,  //Gesture:手势测试
            GestureZoom.class,  //GestureZoom:通过手势缩放图片
            GestureFlip.class,  //GestureFlip:通过手势实现翻页效果
            AddGesture.class,  //AddGesture:添加手势
            RecogniseGesture.class,  //RecogniseGesture:识别手势
            FirstResolverActivity.class, //FirstResolverActivity:使用ContentResolver调用方法
            DictResolverActivity.class,  //使用ContentProvider共享生词本数据
            ContactProviderActivity.class,  //使用ContactProvider管理系统联系人
            MediaProviderActivity.class,  //浏览手机中的图片,ContentProvider
            ContentObserverMonitorSMS.class,  //ContentObserverMonitorSMS:监听用户发出的短信
            BindServiceTest.class,  //BindServiceTest:绑定本地service并与之通信
            IntentServiceTest.class,  //IntentServiceTest：使用IntentService
            AIDLClient.class,  //AIDLClient:客户端访问AIDL
            ComplexClient.class,  //ComplexClient:传递复杂数据的AIDL Service
            SendSms.class,  //发短信
            GroupSendSms.class,  //群发短信
            AudioManagerTest.class,  //使用AudioManager控制音频
            VibratorTest.class,  //Vibrator:振动器
            AlarmTest.class,  //AlarmTest:闹钟测试
            MyReceiverTest.class,  //MyReceiverTest:发送广播
            SortedBroadcastTest.class,  //SortedBroadcastTest:发送有序广播
            MusicBox.class,  //MusicBox:基于service的音乐播放器
            VideoViewTest.class,  //VideoViewTest:播放视频
            GradienterActivity.class,  //水平仪gradienter
            CompassActivity.class,  //指南针compass
            SensorActivity.class,  //传感器sensor
            Texture3DTest.class,  //Texture3D，纹理贴图
            Simple3DTest.class,  //simple3D
            RotatePolygonTest.class,  //旋转多边形，OpenGL 2D
            PolygonTest.class,  //多边形，OpenGL 2D
            SoundPoolTest.class,  //soundPool测试
            BatteryReceiver.class,  //手机电量提醒
            TelephonyManagerTest.class,  //测试telephonyManager
            FirstServiceTest.class,  //测试service
            ThemeStyleActivity.class,  //theme_style展示,
            BitmapBrowserActivity.class,  //浏览手机中的图片,遍历文件
            TestDrawActivity.class,  //4种TestDraw绘画测试,
            BitAssetManagerActivity.class,  //bitmap图片浏览器,AssetManager,
            PopupWindowTest2.class,  //PopupWindow对话框-阻塞,
            AlertDialogTest2.class,  //AlertDialog对话框-非阻塞,
            BlastActivity.class,  //模拟爆炸Blast,
            PinBallActivity.class,  //弹球游戏,
            HandDrawTest.class,  //手写板handDraw,
            CanvasViewTest.class,  //画布cavas,
            AMapActivity.class,  //高德地图,
            PlaneActivity.class,  //打飞机游戏-重力传感器,
            SmsRecordActivity.class,  //信息记录,
            ContactsActivity.class,  //君子通讯录(ListView/ArrayAdapter),
            ContactsActivity2.class,  //君子通讯录2(ListView/SimpleAdapter),
            CallRecordActivity.class,  //通话记录,
            ContactsInAllActivity.class,  //360通讯录(Intent,TabActivity),
            AnimationPandaActivity.class  //熊猫动画
    };

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.home_page);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.home_page_item, titles);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(IndexActivity.this, classes[position]);
    }

}
