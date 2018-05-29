import kotlin.coroutines.experimental.coroutineContext

class Presenter(private val contract: ViewContract) {
  private val model: Model = Model()

  init {
    contract.initList(model.textList)
  }

  fun add(pass: String) {
    if (pass != "") {
      model.textList.addElement(pass)
      contract.onAddToList()
    }
  }

  fun remove(index: Int) {
    if (index != -1) {
      model.textList.remove(index)
    }
  }
}