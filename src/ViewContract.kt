import javax.swing.DefaultListModel

interface ViewContract {
  fun initList(textList: DefaultListModel<String>)

  fun onAddToList()
}