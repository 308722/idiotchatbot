package kr.ac.hallym;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.entities.Activity;

public class App extends ListenerAdapter {
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("MTEwNTA5NTA0MTQ3MjUyODQxNA.GrQmgk.VK0V2u-9XOLEk3h7FVbxaFt0hxcXg-6yKj1P9M")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.getPresence().setActivity(Activity.playing("이세계 아이돌 시청"));
        jda.addEventListener(new App());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;

        Message message = event.getMessage();
        String content = message.getContentRaw();

        if (content.equals("!ping")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue();
        }
        if (content.equals("!일")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("싫은뎅").queue();
        }
        if (content.equals("!백") || content.equals("!백동민")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("하위호환 나가라").queue();
        }
        if (content.equals("!이") || content.equals("!이동민")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("이밑백").queue();
        }
        if (content.equals("!ㅎㅇ")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("안녕").queue();
        }
        if (content.equals("-join")) {
            AudioChannelUnion voicechannel = event.getMember().getVoiceState().getChannel();
        }
       
    }
}
