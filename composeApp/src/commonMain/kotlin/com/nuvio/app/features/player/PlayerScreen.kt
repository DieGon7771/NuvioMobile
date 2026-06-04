package com.nuvio.app.features.player

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nuvio.app.features.player.cast.rememberCastController
import com.nuvio.app.features.player.cast.CastDevicePicker
import com.nuvio.app.features.player.cast.CastConnectionState
import com.nuvio.app.features.player.cast.CastMediaRequest

@Composable
fun PlayerScreen(
    title: String,
    sourceUrl: String,
    sourceAudioUrl: String? = null,
    streamType: String? = null,
    sourceHeaders: Map<String, String> = emptyMap(),
    sourceResponseHeaders: Map<String, String> = emptyMap(),
    externalSubtitles: List<com.nuvio.app.features.streams.StreamSubtitle> = emptyList(),
    providerName: String,
    streamTitle: String,
    streamSubtitle: String?,
    initialBingeGroup: String? = null,
    pauseDescription: String? = null,
    onBack: () -> Unit,
    onOpenInExternalPlayer: ((ExternalPlayerPlaybackRequest) -> Unit)? = null,
    modifier: Modifier = Modifier,
    logo: String? = null,
    poster: String? = null,
    background: String? = null,
    seasonNumber: Int? = null,
    episodeNumber: Int? = null,
    episodeTitle: String? = null,
    episodeThumbnail: String? = null,
    contentType: String? = null,
    videoId: String? = null,
    parentMetaId: String,
    parentMetaType: String,
    parentMetaLogo: String? = null,
    parentMetaPoster: String? = null,
    providerAddonId: String? = null,
    torrentInfoHash: String? = null,
    torrentFileIdx: Int? = null,
    torrentFilename: String? = null,
    torrentMagnetUri: String? = null,
    torrentTrackers: List<String> = emptyList(),
    initialPositionMs: Long = 0L,
    initialProgressFraction: Float? = null,
) {
    val castController = rememberCastController()
    var showCastPicker by remember { mutableStateOf(false) }
    val isCasting = castController?.isCasting == true

    PlayerScreenContent(
        PlayerScreenArgs(
            title = title,
            sourceUrl = sourceUrl,
            sourceAudioUrl = sourceAudioUrl,
            streamType = streamType,
            sourceHeaders = sourceHeaders,
            sourceResponseHeaders = sourceResponseHeaders,
            externalSubtitles = externalSubtitles,
            providerName = providerName,
            streamTitle = streamTitle,
            streamSubtitle = streamSubtitle,
            initialBingeGroup = initialBingeGroup,
            pauseDescription = pauseDescription,
            onBack = onBack,
            onOpenInExternalPlayer = onOpenInExternalPlayer,
            modifier = modifier,
            logo = logo,
            poster = poster,
            background = background,
            seasonNumber = seasonNumber,
            episodeNumber = episodeNumber,
            episodeTitle = episodeTitle,
            episodeThumbnail = episodeThumbnail,
            contentType = contentType,
            videoId = videoId,
            parentMetaId = parentMetaId,
            parentMetaType = parentMetaType,
            parentMetaLogo = parentMetaLogo,
            parentMetaPoster = parentMetaPoster,
            providerAddonId = providerAddonId,
            torrentInfoHash = torrentInfoHash,
            torrentFileIdx = torrentFileIdx,
            torrentFilename = torrentFilename,
            torrentMagnetUri = torrentMagnetUri,
            torrentTrackers = torrentTrackers,
            initialPositionMs = initialPositionMs,
            initialProgressFraction = initialProgressFraction,
        )
    )

    if (showCastPicker && castController != null) {
        CastDevicePicker(
            controller = castController,
            onDismiss = { showCastPicker = false },
        )
    }
}
}
