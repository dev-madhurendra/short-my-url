import { Meta, StoryObj } from '@storybook/react';
import TypographyWithTextField from "./index";

const meta: Meta<typeof TypographyWithTextField> = {
  title: "molecules/TypographyWithTextField",
  component: TypographyWithTextField,
  argTypes: {
    label: { control: 'text' },
    color: { control: 'color' },
    placeholder: { control: 'text' },
    value: { control: 'text' },
    onChange: { action: 'onChange' },
    isPassword: { control: 'boolean' },
    width: { control: 'text' },
    height: { control: 'text' },
    size: { control: 'select', options: ['small', 'medium'] },
    borderRadius: { control: 'text' },
  },
};

export const Default: StoryObj<typeof TypographyWithTextField> = {
  args: {
    label: "Password",
    color: "#344054",
    placeholder: "Enter your Password",
    value: "",
    onChange: () => console.log("onChange triggered"),
    isPassword: true,
    width: "50%",
    height: "40px", 
    size: "small",
    borderRadius: "8px",
  },
};

export default meta;
