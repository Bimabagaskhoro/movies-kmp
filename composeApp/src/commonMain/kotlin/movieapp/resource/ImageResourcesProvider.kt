package movieapp.resource

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
class ImageResourcesProvider : ImageResources {

    @Composable
    override fun ArrowBack(): Painter {
        return painterResource("drawable/compose-multiplatform.xml")
    }
}