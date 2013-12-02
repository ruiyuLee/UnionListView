#UnionListView
===============

* Version:0.7.0
* Date:2013/11/29
* 适宜读者：初级

## 多单元ListView实例
## 预览图
![Screenshot](https://raw.github.com/ruiyuLee/UnionListView/master/picture/device-01.png)

``` 介绍
简单的ListView呈现，
亮点内容是：ListView中可以实现多个Click事件，而且性能比较不错，而且代码耦合性低，复用性和扩展性比较好。


其中使用了Google Volley.jar包，可以很好的进行网络资源读取。

/picture/目录中有运行效果图。
欢迎大牛指出不足，给出更好的解决方案，感谢大家的支持！
``` 

## 用法介绍
* 1.继承UnionAdapter，复写其中方法，类似android API中BaseAdapter用法。

``` 继承UnionAdapter

class TwoUnionAdapter extends UnionAdapter {
...
	@Override
	public int getCount() {
		return array == null ? 0 : array.size();
	}

	@Override
	public Unit getItem(int position) {
		return array.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public UnionView<?> createUnionView() {//该方法只执行一次，只为初始化View
		UnionView<?> unionView = new TwoUnionView(context);//继承自UnionView的实例
		unionView.setChildCount(2);//设置子View个数
		unionView.orderXmlItemView(R.layout.union_list_child_view);//装置子View布局
		unionView.registerClickableViews(R.id.Press, R.id.Close);//注册响应事件的ID
		return unionView;
	}

	@Override
	public UnionView<?> getUnionView(int position, UnionView<?> convertView,
			ViewGroup parent) {//会执行多次，同AdapterView中的getView一样。
		TwoUnionView tu = (TwoUnionView) convertView;
		Unit unit = getItem(position);
		tu.attachData(position, unit.Children);//将数据关联到View中，注意数据类型。
		return convertView;
	}
...
}

``` 

* 2.继承UnionView。

``` 继承UnionView
class TwoUnionView extends UnionView<Object> {
...
	@Override
	protected void onCreateItemView(View child, int position) {
		//创建ViewHolder，为提高性能，作为View的快速入口。
		ChildViewBuffer viewHolder = new ChildViewBuffer(child);
		child.setTag(viewHolder);
	}

	@Override
	protected void setItem(View v, Bean bean) {
		ChildViewBuffer viewHolder = (ChildViewBuffer) v.getTag();
		viewHolder.setItem(bean);
	}
	
	private class ChildViewBuffer {

		public void setItem(Object object) {
			//这里可以做你想做的事情。
		}
	}
...

``` 

* 3.最后，注册事件。

``` 注册事件
mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {

			@Override
			public void onItemChildClick(View view, int position,
					int childPosition, int grandchild, long id) {
				
			}
		});

``` 


## 作者

I’m a young, enthusiastic developer from China.

* E-mail: [ruiyuLee@hotmail.com](mailto:ruiyuLee@hotmail.com)

* Blog: http://www.woolom.com


## Version:0.7.0
Date:2013/11/29

* 抽象UnionView.java；
* 分别建立1/2/3个单元进行测试Widget的扩展性；




## Version:0.5.0
Date:2013/11/28

* ListView的每一项的子View中实现多个Click事件，解决之前版本存在的BUG；
* 子View中右上角添加删除按钮；



## Version:0.0.1
Date:2013/11/27

* ListView的每一项中实现多个Click事件；
