import java.awt.*
import javax.swing.*

class View : JFrame(), ViewContract {
  private var statusLabel: JLabel = JLabel("Input:").apply {
    horizontalAlignment = SwingConstants.CENTER
  }
  private var inputField: JTextField = JTextField(16)
  private lateinit var listView: JList<String>

  // initialize component
  init {
    val contract: ViewContract = this
    val presenter = Presenter(contract)

    val removeButton = Button("REMOVE").apply {
      addActionListener {
        presenter.remove(listView.selectedIndex)
      }
    }
    val scrollView = JScrollPane().apply {
      viewport.view = listView
    }
    val scrollPanel = Box.createHorizontalBox().apply {
      add(Box.createHorizontalStrut(8))
      add(scrollView)
      add(JPanel().apply {
        add(removeButton)
      })
    }

    val loginButton = JButton("ADD").apply {
      addActionListener {
        presenter.add(inputField.text)
      }
    }
    val inputPanel = Box.createHorizontalBox().apply {
      add(Box.createHorizontalStrut(8))
      add(statusLabel)
      add(inputField)
      add(loginButton)
    }

    // initial JFrame and Add to component
    title = "simple-kot-swing"
    defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    add(scrollPanel, BorderLayout.CENTER)
    add(inputPanel, BorderLayout.SOUTH)
    pack()
    isVisible = true
    setLocationRelativeTo(null)
  }

  override fun initList(textList: DefaultListModel<String>) {
    listView = JList(textList)
  }

  override fun onAddToList() {
    inputField.text = ""
  }
}