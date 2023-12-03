package advent.of.code.year2023

import advent.of.code.utils._Problem
import kotlin.reflect.KClass

abstract class Problem(self: KClass<out Problem>) : _Problem(self.simpleName!!)