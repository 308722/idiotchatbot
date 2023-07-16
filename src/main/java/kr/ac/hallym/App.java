package kr.ac.hallym;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.awt.*;

public class App extends ListenerAdapter {
    private Object GuildMessageReceivedEvent;

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("MTEwNTA5NTA0MTQ3MjUyODQxNA.Gm9amP.3OCifCY2rb4A5mwAorEkv_XAl0-MPbwYBLx_eQ")
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
        String content = message.getContentRaw(); //그냥 주석 테스트

        switch (content) {
            case "!ping": {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Pong!").queue();
                break;
            }
            case "!일": {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("싫은뎅").queue();
                break;
            }
            case "!백":
            case "!백동민": {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("하위호환 나가라").queue();
                break;
            }
            case "!이":
            case "!이동민": {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("이밑백").queue();
                break;
            }
            case "!ㅎㅇ": {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("안녕").queue();
                break;
            }
        }
        public void onGuildMessegeReceived (GuildMessageReceivedEvent event){

            if (content.equals("--join")) {
                AudioChannelUnion audioChannel = event.getMember().getVoiceState().getChannel();
                VoiceChannel voiceChannel = audioChannel.asVoiceChannel();
                AudioManager audioManager = event.getGuild().getAudioManager();
                audioManager.openAudioConnection(voiceChannel);
                MessageChannel channel = event.getChannel();

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("멍청한 봇", null);

                eb.setColor(Color.pink);
                //eb.setDescription("text"); 현재 필요 없음

                eb.addField("통화방에 연결됨", "정상적으로 연결됨", false);

                eb.addBlankField(false);

                channel.sendMessageEmbeds(eb.build()).queue();
                while ()

            } else if (content.equals("--quit")) {
                VoiceChannel connectedChannel = (VoiceChannel) event.getGuild().getSelfMember().getVoiceState().getChannel();
                event.getGuild().getAudioManager().closeAudioConnection();
                MessageChannel channel = event.getChannel();
                //channel.sendMessage("통화방 나감").queue();

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("멍청한 봇", null);

                eb.setColor(Color.pink);

                eb.addField("통화방에서 연결 헤제", "정상적으로 해제됨", false);

                eb.addBlankField(false);

                channel.sendMessageEmbeds(eb.build()).queue();
            }


        }
    }
}