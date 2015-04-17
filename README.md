# SimpleRelativeUIFramework
Android上的Relative(响应式）UI框架

    很多时候，组件的变化时依赖于另一个组件，像是点击Button改变TextView的文本：
    
           button.setOnClickListener(new OnClickListener(){
                 @Override
                 public void onClick(View v){
                       textView.setText("");
                 }
           });
    
    这时我们就需要声明button和textView，实际上，只要指明textView和button的依赖关系就可以，像是这样：
    
           @Listener(id = R.id.textview, listener = R.id.button, type = ViewListenerType.TYPE_CLICK)
           private TextView textView;
           
     就指定了TextView的id和它要监听的View的id，以及它需要监听的事件类型。
     我们现在的情况只是为了改变Text，所以在代码中还需要这样写：
           
           ViewController controller = ViewController.getInstance();
           controller.register(this);
           controller.changText(R.id.textview, R.id.button, "你好");
           
     这样就表示在id为R.id.button的Button被点击时，id为R.id.textview的TextView的文本改为“你好”。
     
     还可以指定其他的控件，像是EditText:
     
             @Listener(id = R.id.textview, listener = R.id.edittext, type = ViewListenerType.TYPE_EDIT)
             private TextView textView;
             
             ViewController controller = ViewController.getInstance();
             controller.register(this);
             controller.changText(R.id.textview, R.id.edittext);
      
     这样就会在id为R.id.edittext的EditText输入文本后，id为R.id.textview的TextView的文本就会随着输入而修改。
     
     当然，修改TextView的控件可能有多个，也可以指定：
              
             @Listener(id = R.id.tv_view, listener = {R.id.btn_change, R.id.et_input}, type = {ViewListenerType.TYPE_CLICK, ViewListenerType.TYPE_EDIT})
             private TextView textView;
     
     不仅仅监听控件，还可以监听成员变量的变化。
     首先，model类必须继承自BaseModel:
     
              public class Status extends BaseModel{
                    private String name;
                    
                    public void setName(String name){
                           this.name = name;

                           controller.send(this, DataSendType.TYPE_TEXT);
                    }
              }
              
     然后我们在代码中这样写：
              
                Status status = new Status();
                status.setName("你好");
                controller.bindData(R.id.textview, status, "name");
                status.setName("我好");
                
     当Status调用setName来修改name的时候，id为R.id.textview的TextView也会跟着修改。
                
     还可以将多个控件绑定到多个成员变量身上：
     
               Status status = new Status();
               status.setName("我好");
               status.setId("01");
               controller.bindData(R.id.tv_name, status, "name");
               controller.bindData(R.id.tv_id, status, "id");
               status.setName("他好");
               status.setId("02");
    
