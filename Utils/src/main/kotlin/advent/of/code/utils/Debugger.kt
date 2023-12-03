package advent.of.code.utils

public object Debugger : Inspector {

    override fun solution(block: InspectorScope.() -> Unit) {
        InspectorImpl().solution(block)
    }
}