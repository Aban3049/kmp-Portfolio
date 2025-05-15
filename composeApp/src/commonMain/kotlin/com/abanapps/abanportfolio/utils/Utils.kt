package com.abanapps.abanportfolio.utils

import abanportfolio.composeapp.generated.resources.Res
import abanportfolio.composeapp.generated.resources.ai_chat_keyboard_icon
import abanportfolio.composeapp.generated.resources.audio_amplifier_icon
import abanportfolio.composeapp.generated.resources.bt_remote_app_icon
import abanportfolio.composeapp.generated.resources.ppt_file_viewer_icon
import abanportfolio.composeapp.generated.resources.video_editing_app_icon
import abanportfolio.composeapp.generated.resources.vin_icon
import com.abanapps.abanportfolio.models.Project

object Utils {

    val drawerItems = listOf(
        "Home",
        "About",
        "Experience",
        "Projects",
        "Contact"
    )

    val projectsList = listOf(

        Project(
            appName = "MP3 Converter",
            appImage = Res.drawable.video_editing_app_icon,
            projectDate = "Jan 2025 - Feb 2025",
            projectKeyFeatures = listOf(
                "Convert video to audio effortlessly",
                "Cut & merge audio and video files",
                "Full-featured video editor with trimming",
                "Convert files between multiple formats",
                "Compress videos without losing quality"
            ),
            onPlayStore = true,
            appStoreLink = "https://play.google.com/store/apps/details?id=com.videotomp3audioconverter.convertmp4videotomp3audio&hl=en",
            appDownloads = "100k+"
        ),

        Project(
            appName = "AI Chat Keyboard",
            appImage = Res.drawable.ai_chat_keyboard_icon,
            projectDate = "Dec 2024 - Dec 2024",
            projectKeyFeatures = listOf(
                "Multi-functional AI Chat Keyboard",
                "Customizable keyboard themes",
                "Intelligent text correction using Gemini",
                "AI-based word suggestions for typing",
                "Portrait & landscape mode compatibility"
            )
        ),

        Project(
            appName = "BT Tv Remote",
            appImage = Res.drawable.bt_remote_app_icon,
            projectDate = "Feb 2025 - Mar 2025",
            projectKeyFeatures = listOf(
                "Bluetooth remote control for TVs",
                "Gamepad mode for gaming",
                "Google Cast for media streaming",
                "Channel & volume control",
                "Multi-language support"
            )
        ),

        Project(
            appName = "Audio Amplifier",
            appImage = Res.drawable.audio_amplifier_icon,
            projectDate = "Jul 2024 - Jul 2024",
            projectKeyFeatures = listOf(
                "Audio amplification & volume boosting",
                "Advanced equalizer for custom tuning",
                "Speaker cleaner for improved audio",
                "Seamless local audio & video playback",
                "Intuitive interface for effortless control"
            ),
            onPlayStore = true,
            appDownloads = "100+",
            appStoreLink = "https://play.google.com/store/apps/details?id=com.strco.musicplayer.audioamplifier.volumebooster.speakercleaner"
        ),

        Project(
            appName = "PPT File Viewer",
            appImage = Res.drawable.ppt_file_viewer_icon,
            projectDate = "Sep 2024 - Sep 2024",
            projectKeyFeatures = listOf(
                "Multi-format document viewer",
                "Supports PPT, DOC, XLS, PDF & CSV",
                "Secure storage access",
                "Elegant & user-friendly interface",
                "Fast & efficient document rendering"
            )
        ),

        Project(
            appName = "VIN Decoder",
            appImage = Res.drawable.vin_icon,
            projectDate = "Oct 2024 - Oct 2024",
            projectKeyFeatures = listOf(
                "Instant VIN lookup for vehicle details",
                "Real-time data on make, model & more",
                "Multi-language support for global users",
                "Ideal for buyers, sellers & enthusiasts",
                "Secure & reliable vehicle data retrieval"
            )

        )

    )


}