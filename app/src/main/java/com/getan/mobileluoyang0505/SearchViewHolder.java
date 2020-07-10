package com.getan.mobileluoyang0505;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.getan.mobileluoyang0505.utils.KeyBoardUtils;
import com.getan.mobileluoyang0505.utils.MyAnimationUtils;

import butterknife.BindView;


/*这是Android开发里面的。baidu　PopupWindow使用
        　　PopupWindow这个类用来实现一个弹出框，可以使用任意zhi布局的View作为其内容，dao这个弹出框是悬浮在当前activity之上的。*/
public class SearchViewHolder implements View.OnClickListener {
    //大小写快捷键  大小写转换 Ctrl + Shift + U
    public static final int RESULT_SEARCH_EMPTY_KEYWORD = 0;
    public static final int RESULT_SEARCH_KEYWORD = 1;
    public static final int RESULT_SEARCH_CANCEL = 2;
    public static final int RESULT_SEARCH_GO_SCAN = 3;
    private Activity mContext;
    @BindView(R.id.iv_arrow_back)
    ImageView iv_back;
    @BindView(R.id.iv_scan)
    ImageView iv_scan;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.et_search_content)
    public EditText et_search_content;
    @BindView(R.id.iv_fork_clear)
    ImageView iv_clear;

    private OnSearchHandlerListener mListener;
    private  View mSearchView;

    public SearchViewHolder(Activity context, OnSearchHandlerListener listener) {

        this.mListener = listener;
        this.mContext = context;
        //View inflate = View.inflate(this, R.layout.search, null);
        //this.mSearchView = LayoutInflater.from(mContext).inflate(R.layout.search, null);
        this.mSearchView = LayoutInflater.from(context).inflate(R.layout.search, null);
        //ButterKnife.bind(this,mSearchView);
        Log.d("", "showSearchView: >>>>>>>>>>>>>>>>>>>>>>>>>"+mSearchView.getHeight());
        initView();
        initEvent();
    }

    private void initView() {
        iv_back = (ImageView) mSearchView.findViewById(R.id.iv_arrow_back);
        iv_scan = (ImageView) mSearchView.findViewById(R.id.iv_scan);
        iv_clear = (ImageView) mSearchView.findViewById(R.id.iv_fork_clear);
        iv_search = (ImageView) mSearchView.findViewById(R.id.iv_search);
        et_search_content = (EditText) mSearchView.findViewById(R.id.et_search_content);
    }

    public View getContentView(){
        return mSearchView;
    }

    private void initEvent() {
        iv_back.setOnClickListener(this::onClick);
        iv_scan.setOnClickListener(this::onClick);
        iv_clear.setOnClickListener(this::onClick);
        iv_search.setOnClickListener(this::onClick);
        et_search_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    iv_clear.setVisibility(View.VISIBLE);
                }else {
                    iv_clear.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_search_content.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    if (et_search_content.getText().toString().isEmpty()){
                        if (mListener!=null){
                            et_search_content.startAnimation(MyAnimationUtils.shakeAnimation(5));
                            mListener.search(SearchViewHolder.RESULT_SEARCH_EMPTY_KEYWORD);
                        }
                        return false;

                    }else {
                        if(mListener!=null){
                            KeyBoardUtils.closeKeyBord(et_search_content,mContext);
                            mListener.search(SearchViewHolder.RESULT_SEARCH_KEYWORD);
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_arrow_back:
                //KeyBoardUtils.closeKeyBord(et_search_content, mContext);
                if (mListener != null) {
                    mListener.search(SearchViewHolder.RESULT_SEARCH_CANCEL);
                }
                break;
            case R.id.iv_scan:
                if (mListener != null) {
                    mListener.search(SearchViewHolder.RESULT_SEARCH_GO_SCAN);
                }
                break;
            case R.id.iv_fork_clear:
                et_search_content.setText("");
                break;
            case R.id.iv_search:
                if (et_search_content.getText().toString().isEmpty()) {
                    et_search_content.startAnimation(MyAnimationUtils.shakeAnimation(5));
                    if (mListener != null) {
                        //et_search_content.startAnimation(MyAnimationUtils.shakeAnimation(5));
                        mListener.search(SearchViewHolder.RESULT_SEARCH_EMPTY_KEYWORD);
                    }
                    break;
                }
                if (mListener != null) {
                    KeyBoardUtils.closeKeyBord(et_search_content, mContext);
                    mListener.search(SearchViewHolder.RESULT_SEARCH_KEYWORD);
                }
                break;
            default:
                break;
        }
    }

    public interface OnSearchHandlerListener{
        void search(int code);
    }
}
