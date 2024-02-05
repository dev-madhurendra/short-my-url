import { Meta, StoryObj } from "@storybook/react";
import SocialLogin from ".";
import FaceBookLogo from '../../../../public/assets/images/facebook.svg'
import GoogleLogo from '../../../../public/assets/images/google.svg'
import MicrosoftLogo from '../../../../public/assets/images/microsoft.svg'

export default {
  title: "molecules/SocialLogin",
  component: SocialLogin,
} as Meta<typeof SocialLogin>;


export const GoogleLogin: StoryObj<typeof SocialLogin> = {
  args: {
    text: 'Google',
    src: GoogleLogo,
  },
};

export const FaceBookLogin: StoryObj<typeof SocialLogin> = {
  args: {
    text: 'Facebook',
    src: FaceBookLogo, 
  },
};

export const MicrosoftLogin: StoryObj<typeof SocialLogin> = {
  args: {
    text: 'Microsoft',
    src: MicrosoftLogo,
  },
};
